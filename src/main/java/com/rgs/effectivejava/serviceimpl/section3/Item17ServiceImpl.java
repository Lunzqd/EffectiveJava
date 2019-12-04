package com.rgs.effectivejava.serviceimpl.section3;

import com.rgs.effectivejava.core.util.StringUtil;
import com.rgs.effectivejava.entity.section3.DtoUser;
import com.rgs.effectivejava.entity.section3.VoUser;
import com.rgs.effectivejava.interfaces.section3.Item17Service;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class Item17ServiceImpl implements Item17Service {

    @Override
    public Boolean updateUser(VoUser user) {

        if(StringUtil.isEmpty(user.getId())){
            return false;
        }

        //方式一：
        //获取对象，直接修改
        DtoUser dtoUser=this.getUserById(user.getId());
        dtoUser.setName(user.getName());
        dtoUser.setGender(user.getGender());
        dtoUser.setDateOfBirth(user.getDateOfBirth());
        this.updateUserById(dtoUser);

        //方式二：
        //使用初始化对象修改
        /*DtoUser beforeUser=this.getUserById(user.getId());

        DtoUser dtoUser=new DtoUser();
        dtoUser.setId(user.getId());
        //Just change name
        dtoUser.setName(user.getName());
        this.updateUserById(dtoUser);
        log.info(String.format("User is updated, before value:%s, updated value%s",beforeUser.toString(),dtoUser.toString()));*/


        return true;

    }

    private DtoUser getUserById(String id) {

        DtoUser dtoUser=new DtoUser();
        dtoUser.setId("100");
        dtoUser.setName("Mecurry");
        dtoUser.setGender("Male");

        try{
            SimpleDateFormat dtFormat=new SimpleDateFormat("yyyy-MM-dd");
            String strDate="1990-05-06";
            dtoUser.setDateOfBirth(dtFormat.parse(""));
        }catch(Exception ex){

        }
        return dtoUser;
    }

    private Integer updateUserById(DtoUser user){
        return 1;
    }
}
