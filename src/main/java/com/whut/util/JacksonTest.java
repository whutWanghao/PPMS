package com.whut.util;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whut.domain.Department;
import com.whut.domain.Employee;

import java.text.SimpleDateFormat;

public class JacksonTest {

    public static void main(String[] args) throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        //当反序列化json时，未知属性会引起的反序列化被打断，这里我们禁用未知属性打断反序列化功能
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        Department dJson=mapper.readValue("{\"did\":\"1\",\"dname\":\"IOS开发部\",\"desc\":\"略\",\"setdate\":\"2017-7-01\"}",Department.class);
        System.out.println("did:"+dJson.getDid()+",dname:"+dJson.getDname()+",desc:"+dJson.getDesc()+",setdate:"+dJson.getSetdate());

        Employee employee=new Employee();
        employee.setEname("王岐山");
        employee.setGender("男");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        employee.setBirthday(simpleDateFormat.parse("1950-5-28"));
        employee.setEid(6);
        employee.setDepartment(dJson);
        String json=mapper.writeValueAsString(employee);
        System.out.println(json);
    }
}
