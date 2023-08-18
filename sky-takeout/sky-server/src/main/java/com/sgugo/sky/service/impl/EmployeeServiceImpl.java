package com.sgugo.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sgugo.sky.constant.MessageConstant;
import com.sgugo.sky.constant.PasswordConstant;
import com.sgugo.sky.constant.StatusConstant;
import com.sgugo.sky.context.BaseContext;
import com.sgugo.sky.dto.EmployeeDTO;
import com.sgugo.sky.dto.EmployeePageQueryDTO;
import com.sgugo.sky.exception.AccountLockedException;
import com.sgugo.sky.exception.AccountNotFoundException;
import com.sgugo.sky.exception.PasswordErrorException;
import com.sgugo.sky.mapper.EmployeeMapper;
import com.sgugo.sky.service.EmployeeService;
import com.sgugo.sky.dto.EmployeeLoginDTO;
import com.sgugo.sky.entity.Employee;
import com.sgugo.sky.utils.EncryptMd5;
import com.sgugo.sky.vo.PageResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 员工业务处理类
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        //获取Controller传递的用户名和密码
        String username = employeeLoginDTO.getUsername();
        String password = employeeLoginDTO.getPassword();

        // 1. 根据用户名查询用户数据信息
        Employee employee = employeeMapper.getByUsername(username);

        // 2. 处理账号相关的异常：用户不存在、密码错误、账号被冻结
        // 2.1 账号不存在
        if(employee == null){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        // 2.2 密码比对!
        if(!EncryptMd5.checkMd5Pass(password,employee.getPassword())){
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        //2.3 账号被冻结
        if(employee.getStatus() == 0){
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        //3. 返回Employee对象给Controller
        return employee;
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {
        // 1. 将DTO转为PO（entity），因为Dao层操作数据库要操作PO
        Employee employee = new Employee();
        // 将DTO中的数据拷贝到PO
        BeanUtils.copyProperties(employeeDTO,employee);

        // 2. 为entity 增加额外数据
        // 2.1 设置账号的状态，默认正常状态 1表示正常 0表示锁定
        employee.setStatus(StatusConstant.ENABLE);
        //2.2 设置默认密码，新增账号是采用默认密码的，默认密码需要进行加密
        employee.setPassword(EncryptMd5.getMd5Pass(PasswordConstant.DEFAULT_PASSWORD));

        //3. 设置当前记录创建人id和修改人id
        //从ThreadLocal中获取当前登录用户的id
        employee.setCreateUser(BaseContext.getId());
        employee.setUpdateUser(BaseContext.getId());

        //4. 调用Dao层，完成数据插入
        employeeMapper.insert(employee);
    }

    /**
     * 员工分页查询
     * @param employeePageQueryDTO DTO
     * @return VO
     */
    @Override
    public PageResultVO pageQuery(EmployeePageQueryDTO employeePageQueryDTO) {
        //select * from employee limit 0,10

        //调用分页插件进行分页查询
        PageHelper.startPage(employeePageQueryDTO.getPage(),employeePageQueryDTO.getPageSize());

        //调用DAO进行分页查询，获取数据
        Page<Employee> page = employeeMapper.pageQuery(employeePageQueryDTO);

        // 获取分页信息
        long total = page.getTotal();

        List<Employee> records = page.getResult();

        //返回分页VO
        return new PageResultVO(total,records);
    }

    /**
     * 启用或禁用员工
     * @param status 员工状态，1启用，0禁用
     * @param id 被操作的员工id
     */
    @Override
    public void startOrStop(Integer status, Long id) {
        Employee employee = new Employee();
        employee.setStatus(status);
        employee.setId(id);

        employeeMapper.update(employee);
    }

    /**
     * 根据id查询员工
     * @param id 员工的id
     * @return 员工的信息
     */
    @Override
    public Employee getById(Long id) {
        Employee employee = employeeMapper.getById(id);
        //不能显示明文密码，见密码设置为***
        employee.setPassword("*****");
        return employee;
    }

    /**
     * 修改员工信息
     * @param employeeDTO DTO
     */
    @Override
    public void update(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);

        employee.setUpdateTime(LocalDateTime.now());
        employee.setUpdateUser(BaseContext.getId());

        employeeMapper.update(employee);
    }
}
