package com.company.domain;

import java.util.Date;

/**
 * @Description: 实体类 Person
 * @Author: YoYo
 * @Date: 2019-12-18 22:55
 */
public class PersonDomain {
    private int personNo;
    private String name;
    private String sex;
    private Date birthday;

    public int getPersonNo() {
        return personNo;
    }

    public void setPersonNo(int personNo) {
        this.personNo = personNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "PersonDomain{" +
                "personNo=" + personNo +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
