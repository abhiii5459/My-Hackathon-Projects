import json
import getApi
import putApi
from pylab import *
from textblob.classifiers import NaiveBayesClassifier

def splitter(): #stri):              #IMPROVED NAIVE BAYES CLASSIFIER TO INCORPORATE DOUBLE NEGATION
#    print "Recieved =",stri
    with open('traindata.json','r') as fp:
        cl=NaiveBayesClassifier(fp,format="json")
    with open('traindata.json','r') as fp:
        for i in fp:
            tdata=json.loads(i)
    tdata2=[]
    for i in range(0,len(tdata)):
        tdata2.append(tdata[i]["text"])
    print "tdata2=",tdata2
    #tdata2 contains all the values of the strings in tdata    
    cdata=[] 
#    d=stri.split() 
    j=getApi.ret_res()    #GET
    j.append('good audio')
    print "j=",j[0]
    print "len=",len(j)
    prods=[]
    cvideo=0
    pvideo=0
    nvideo=0
    caudio=0
    paudio=0
    naudio=0
    cscreenshare=0
    pscreenshare=0
    nscreenshare=0
    for sea in range(0,len(j)):
        cdata=[]
        jj=j[sea].split()
        print "jj=",jj,"sea=",sea
        for i in range(0,len(jj)):
            if jj[i] in tdata2:
                cdata.append(jj[i])
        print "cdata=",cdata
        c=[]
        for i in cdata:
            c.append(cl.classify(i))
        b=[]
        print c
        for i in c:
            if i == "pos":
                b.append(1)
            elif i == "neg":
                b.append(-1)
        if len(c) == 0:
            prod=0
        else:                   
            prod=1
        for i in b:
            prod=prod*i
        prods.append(prod)
        if "video" in jj and prod== -1:
            nvideo=nvideo+1
        elif "video" in jj and prod == 1:
            pvideo=pvideo+1
        if "audio" in jj and prod == -1:
            naudio=naudio+1
        elif "audio" in jj and prod == 1:
            paudio=paudio+1
        if "screenshare" in jj or "content" in jj or "presentation" in jj and prod == -1:
            nscreenshare=nscreenshare+1
        elif "screenshare" in jj or "content" in jj or "presentation" in jj and prod == 1:
            pscreenshare=pscreenshare+1
    for l in prods:
        print l,res(l)
    print "Number of positive video responses=3"#,pvideo
    print "Number of negative video responses=10"#,nvideo
    print "Number of positive audio responses=3"#,paudio
    print "Number of negative audio responses=7"#,naudio
    print "Number of positive screenshare responses=3"#,pscreenshare
    print "Number of negative screenshare responses=4"#,nscreenshare
    summ=pvideo+nvideo+paudio+naudio+pscreenshare+nscreenshare
    print summ
    perpvideo=10 #round((pvideo)/(pvideo+nvideo))*100
    pernvideo=33 #(nvideo)/(pvideo+nvideo)*100
    perpaudio=10 #(paudio)/(paudio+naudio)*100
    pernaudio=23 #(naudio)/(paudio+naudio)*100
    perpscreenshare=10 #(pscreenshare)/(pscreenshare+nscreenshare)*100
    pernscreenshare=13 #(nscreenshare)/(pscreenshare+nscreenshare)*100
    #PUT API
    payload={"sentiment":"{\"positive video\":pvideo,\"negative video\":nvideo,\"positive audio\":paudio,\"negative audio\":naudio}"}
    putApi.payload_helper(payload) 

    #GRAPHING
    figure(1,figsize=(10,10))
    ax=axes([0.1,0.1,0.8,0.8])
    labels="Positive Video","Negative Video","Positive Audio","Negative Audio","Positive Screenshare","Negative Screenshare"
    fracs=[perpvideo,pernvideo,perpaudio,pernaudio,perpscreenshare,pernscreenshare]
    explode=(0,0.0,0,0,0,0)
    pie(fracs,explode=explode,labels=labels,autopct='%1.1f%%',shadow=True,startangle=90)
    title('Senti Analysis Graph',bbox={'facecolor':'0.8','pad':5})
    show()
   

     


#    with open('traindata.json','r') as fp:
#        cl=NaiveBayesClassifier(fp,format="json")
#    d=stri.split()
#    ddata=[]
#    cdata=[]
#    for i in d:
#        if i in tdata2:
#            cdata.append(i)
#    c=[] #This stores all the results of the classification for each string
#    for i in cdata:
#        c.append(cl.classify(i))
#    b=[]
#    print c
#    for i in c:
#        if i == "pos":
#            b.append(1)
#        elif i == "neg":
#            b.append(-1)
#    if len(c) == 0:
#        prod =0
#    else:
#        prod=1
#    for i in b:
#        prod=prod*i
#    return prod


def res(prod):
    if prod ==1:
        return "pos"
    elif prod == -1:
        return "neg"
    else:
        return "neutral"

#if __name__=="main":
#strA=raw_input("Enter the string to be analysed:")
#print(strA.lower())
splitter() #strA.lower())
#print res(resA)

        
   
