import requests
import json

def payload_helper(payload):
    url = 'Insert PUT API URL here'
    payloads = payload #{"sentiment":"{\"positive video\":0,\"negative video\":2}"}
    headers = {'content-type': 'application/json'}
    r = requests.post(url, data=json.dumps(payloads), headers=headers)
    print r.text
