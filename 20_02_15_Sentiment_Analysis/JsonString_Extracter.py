import json


def searchingForStringInJson(JsonString):
    print type(JsonString)
    print JsonString[0]
    print len(JsonString[0])
    body_list= (JsonString[0]["sender"]["userId"])
    length=len(JsonString)
    for i in range(0,length)
        for j in range(0,len(JsonString[i]["messages"]))
            print JsonString[i]["messages"][j]["body"]
  
     

searchingForStringInJson(Jsonbody)