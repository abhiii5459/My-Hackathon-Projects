import requests

def ret_res():
    r=requests.get("Insert GET API URL HERE")
    bodym=[]
    for i in range(0,len(r.json()["messages"])):
        bodym.append(r.json()["messages"][i]["body"])
    print bodym
    return bodym
