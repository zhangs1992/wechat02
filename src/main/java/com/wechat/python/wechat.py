#coding=utf8

import itchat
import pandas as pd
import numpy as np
import pymysql
import xlrd
import sys



# 接收系统输入参数
path=sys.argv[1]
chatroomName=sys.argv[2]
# chatroomName='test22'

# itchat.auto_login(True)
# itchat.auto_login(enableCmdQR=True)

# data=pd.read_csv(filepath)
# path='/Users/xuyouchang/Downloads/wechat.xls'
data=pd.read_excel(path,header=7)
data=data.fillna(0)

name_list=np.array(data['旅客姓名']).tolist()
category_list=np.array(data['类别']).tolist()
id_card_list=np.array(data['证件号']).tolist()
sex_list=np.array(data['性别']).tolist()
age_list=np.array(data['年龄']).tolist()
ticket_num_list=np.array(data['票号']).tolist()
weChat_id_list=np.array(data['微信ID（每人必填项）']).tolist()
contact_list=np.array(data['联系方式']).tolist()
child_contact_list=np.array(data['子女或亲友联系方式（必填项）']).tolist()
residence_list=np.array(data['住所（便于安排接送机，请具体至小区）']).tolist()
seat_requirements_list=np.array(data['机上座位等其他要求（靠窗、几人坐在一起等）']).tolist()
office_list=np.array(data['办事处']).tolist()
passenger_region_list=np.array(data['旅客地域']).tolist()
passenger_source_list=np.array(data['旅客来源（组团社/地接社名称）']).tolist()
food_requirements_list=np.array(data['餐食要求（请从餐食可选内容中选择）']).tolist()
meal_optional_content_list=np.array(data['餐食可选内容']).tolist()

# 打开数据库连接
db = pymysql.connect(host='127.0.0.1', port=3307,user="root", passwd="root", db="wechat", use_unicode=True, charset="utf8")
# 使用 cursor() 方法创建一个游标对象 cursor
cursor = db.cursor()

for index in range(len(name_list)):
    if name_list[index] == 0:
        break
    else:
        value = "'" + name_list[index] + "'" + ',' + str(id_card_list[index]) + ',' + "'" + sex_list[
            index] + "'" + ',' + str(age_list[index]) + ',' + "'" + category_list[index] + "'" + ',' + \
                str(ticket_num_list[index]) + ',' + "'" + str(weChat_id_list[index]) + "'" + ',' + str(
            contact_list[index]) + ',' + str(child_contact_list[index]) + ',' \
                + "'" + residence_list[index] + "'" + ',' + "'" + seat_requirements_list[index] + "'" + ',' + "'" + \
                office_list[index] + "'" + ',' + "'" + passenger_region_list[index] + "'" \
                + ',' + "'" + passenger_source_list[index] + "'" + ',' + "'" + food_requirements_list[
                    index] + "'" + ',' + "'" + meal_optional_content_list[index] + "'" + ',' \
                + str(1)+','+"'"+chatroomName+"'"
        sql = "insert into mem(name,id_card,sex,age,category,ticket_num,we_chat_id,contact,child_contact,residence,\
            seat_requirements,office,passenger_region,passenger_source,food_requirements,meal_optional_content,is_in_group,chatroom) \
            values(" + value + ")"
        #         print(sql)
        try:
            # 执行sql语句
            cursor.execute(sql)
            # 提交到数据库执行
            db.commit()
        except:
            # 如果发生错误则回滚
            db.rollback()


memberlist=[]
for member in weChat_id_list:
    if member!=0:
        memberlist.append(member)

memberUsername = []
friendlist = itchat.get_friends()[1:]
outfriendlist=[]
nicknamelist=[]
for friend in friendlist:
    if friend['NickName'] in memberlist:
        memberUsername.append(friend)

for member in memberUsername:
    nicknamelist.append(member['NickName'])

for nickname in memberlist:
    if nickname in nicknamelist:
        print(str(nickname)+" in group")
    else:
        print(str(nickname)+" not in group")
        outfriendlist.append(nickname)

for mem in outfriendlist:
    sql2="update mem set is_in_group= 0 where we_chat_id= "+ "'"+str(mem)+"'"
    print(sql2)
    try:
        # 执行sql语句
        cursor.execute(sql2)
        # 提交到数据库执行
        db.commit()
    except:
        # 如果发生错误则回滚
        db.rollback()

# r = itchat.create_chatroom(memberUsername, chatroomName)
# if r:
#     r = itchat.send('new chatroom', r[chatroomName])
#
# print(r)


print("finish")
