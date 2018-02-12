import xlrd
import simplejson as json
from collections import OrderedDict

def convertXlsToJson(file_name):
    wb=xlrd.open_workbook(file_name)
    sh=wb.sheet_by_index(0)
    target_list=[]
    for rownum in range(0,sh.nrows):
        target_rows=OrderedDict()
        row_values=sh.row_values(rownum)
        target_rows['row_id']=row_values[0]
        target_rows['row_msg']=row_values[1]
        target_list.append(target_rows)
    j=json.dumps(target_list)
    with open('target_file.json','w') as f:
        f.write(j)

#if __name__=="main":
fname=raw_input("Enter file name:")
convertXlsToJson(fname)
