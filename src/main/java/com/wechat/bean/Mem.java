package com.wechat.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @Author: Youchang Xu
 * @Description:
 * @Date: created in 14:02 2018/7/14
 * @Modified By:
 */
@Entity
public class Mem {
    private int id;
    private String name;
    private String idCard;
    private String sex;
    private Integer age;
    private String category;
    private String ticketNum;
    private String contact;
    private String childContact;
    private String residence;
    private String seatRequirements;
    private String office;
    private String passengerRegion;
    private String passengerSource;
    private String foodRequirements;
    private String mealOptionalContent;
    private String isInGroup;
    private String weChatId;
    private String chatroom;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "ticket_num")
    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    @Basic
    @Column(name = "contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "child_contact")
    public String getChildContact() {
        return childContact;
    }

    public void setChildContact(String childContact) {
        this.childContact = childContact;
    }

    @Basic
    @Column(name = "residence")
    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    @Basic
    @Column(name = "seat_requirements")
    public String getSeatRequirements() {
        return seatRequirements;
    }

    public void setSeatRequirements(String seatRequirements) {
        this.seatRequirements = seatRequirements;
    }

    @Basic
    @Column(name = "office")
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Basic
    @Column(name = "passenger_region")
    public String getPassengerRegion() {
        return passengerRegion;
    }

    public void setPassengerRegion(String passengerRegion) {
        this.passengerRegion = passengerRegion;
    }

    @Basic
    @Column(name = "passenger_source")
    public String getPassengerSource() {
        return passengerSource;
    }

    public void setPassengerSource(String passengerSource) {
        this.passengerSource = passengerSource;
    }

    @Basic
    @Column(name = "food_requirements")
    public String getFoodRequirements() {
        return foodRequirements;
    }

    public void setFoodRequirements(String foodRequirements) {
        this.foodRequirements = foodRequirements;
    }

    @Basic
    @Column(name = "meal_optional_content")
    public String getMealOptionalContent() {
        return mealOptionalContent;
    }

    public void setMealOptionalContent(String mealOptionalContent) {
        this.mealOptionalContent = mealOptionalContent;
    }

    @Basic
    @Column(name = "is_in_group")
    public String getIsInGroup() {
        return isInGroup;
    }

    public void setIsInGroup(String isInGroup) {
        this.isInGroup = isInGroup;
    }

    @Basic
    @Column(name = "we_chat_id")
    public String getWeChatId() {
        return weChatId;
    }

    public void setWeChatId(String weChatId) {
        this.weChatId = weChatId;
    }

    @Basic
    @Column(name = "chatroom")
    public String getChatroom() {
        return chatroom;
    }

    public void setChatroom(String chatroom) {
        this.chatroom = chatroom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mem mem = (Mem) o;
        return id == mem.id &&
                Objects.equals(name, mem.name) &&
                Objects.equals(idCard, mem.idCard) &&
                Objects.equals(sex, mem.sex) &&
                Objects.equals(age, mem.age) &&
                Objects.equals(category, mem.category) &&
                Objects.equals(ticketNum, mem.ticketNum) &&
                Objects.equals(contact, mem.contact) &&
                Objects.equals(childContact, mem.childContact) &&
                Objects.equals(residence, mem.residence) &&
                Objects.equals(seatRequirements, mem.seatRequirements) &&
                Objects.equals(office, mem.office) &&
                Objects.equals(passengerRegion, mem.passengerRegion) &&
                Objects.equals(passengerSource, mem.passengerSource) &&
                Objects.equals(foodRequirements, mem.foodRequirements) &&
                Objects.equals(mealOptionalContent, mem.mealOptionalContent) &&
                Objects.equals(isInGroup, mem.isInGroup) &&
                Objects.equals(weChatId, mem.weChatId) &&
                Objects.equals(chatroom, mem.chatroom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, idCard, sex, age, category, ticketNum, contact, childContact, residence, seatRequirements, office, passengerRegion, passengerSource, foodRequirements, mealOptionalContent, isInGroup, weChatId, chatroom);
    }
}
