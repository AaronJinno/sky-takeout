package com.sgugo.skyserver;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;
//import org.springframework.util.DigestUtils;

import java.util.*;

@SpringBootTest
public class BaseTest {

    @Test
    void stringTest(){
        String result = StringUtils.abbreviate("hello word", 5);
        System.out.println(result);
    }

    @Test
    void randomTest(){
        //1.返回一个随机布尔值
        boolean b = RandomUtils.nextBoolean();
        System.out.println(b);
        //结果：true

        //2. 返回int正整数：可指定范围
        int i1 = RandomUtils.nextInt();
        int i2 = RandomUtils.nextInt(10, 100);
        System.out.println(i1); //1439218707
        System.out.println(i2); //90


        //3. 随机生成指定长度的byte数组，数组值是数字（自然数）
        byte[] bytes = RandomUtils.nextBytes(5);
        System.out.println(Arrays.toString(bytes));
        //结果：[29, -17, -101, 8, -51]
    }

    @Test
    void randomStringTest() {
        //1. 随机生成指定位数的数字字符串
        String random1 = RandomStringUtils.randomNumeric(5);
        System.out.println(random1); //54141

        //2.返回任意个数的指定返回的数字字符组成的随机数
        String random2 = RandomStringUtils.randomNumeric(1,10);
        System.out.println(random2); //54141

        //3.返回指定位数的随机字符串，内容随机
        String random3 = RandomStringUtils.random(2);
        System.out.println(random1); //ꖾ댿

        //4. 从指定范围中生成长度为n的随机字符串
        String random4 = RandomStringUtils.random(3, "西门吹雪");
        System.out.println(random2); //西吹门

    }

    @Test
    void numberTest(){
        //1. 从数组中选出最大值：数组类型任意
        int max = NumberUtils.max(new int[] {1, 2, 4, 5});
        System.out.println(max); //5

        //2.判断字符串是否全是整数
        boolean digits = NumberUtils.isDigits("23");
        System.out.println(digits); //true

        //3.比较两个number类型数值的大小：-1=第一个小，0=想等，1=第一个大
        int compare = NumberUtils.compare(1, 2);
        System.out.println(compare); //-1

        //4.使用字符串传给你就要给Number类型的值
        Number number = NumberUtils.createNumber("2323");
        System.out.println(number); //2323

        //5. 将字符串转为int类型
        int i = NumberUtils.toInt("123");
        System.out.println(i); //123
    }

    @Test
    void dateTest(){
        Date date1 = DateUtils.addHours(new Date(), 1);
        System.out.println(date1);

        boolean sameDay = DateUtils.isSameDay(new Date(), new Date());
        System.out.println(sameDay);
    }

    @Test
    void arrayTest(){
        Integer[] integers = ArrayUtils.toArray(1, 2, 3);
        System.out.println(Arrays.toString(integers));

        Integer[] intArr = {};
        boolean empty = ArrayUtils.isEmpty(intArr);
        System.out.println(empty);

        String[] strArr = {"hello","jinno","aaron"};
        boolean b = ArrayUtils.contains(strArr, "jinno");
        System.out.println(b);

        String [][]  strArr2 = new String[][]{
                { "RED", "#FF0000" },
                { "GREEN", "#00FF00" },
                { "BLUE", "#0000FF" }
        };
        Map<Object, Object> map1 = ArrayUtils.toMap(strArr2);
        System.out.println(map1);
    }

    @Test
    void digestTest(){
        //String password = "123456"; //明文密码
        //String salt = "shit"; //加盐
        //// 1. md5加密
        //String md5Pass = DigestUtils.md5DigestAsHex((password+salt).getBytes());
        //System.out.println(md5Pass);//185240580d18f1e6104567225514dac9
        //
        ////2. md5验证
        //String userPass = "185240580d18f1e6104567225514dac9";
        //boolean equals = md5Pass.equals(userPass);
        //System.out.println(equals); //true

    }
}
