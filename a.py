import requests
import os
def predict():
	url = "http://cl-api.vize.ai/3388"
	path = os.path.dirname(__file__)
	print(path+'aaaa')
	t = os.path.join(path,'static/out.jpg')
	print(t)
	files = {'image':open(t,'rb')} #use path to your image

	headers = {"Authorization": "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjMyNjEsImlhdCI6MTUxMDQ3NjIxNCwiZXhwIjoxNTE4MjUyMjE0fQ._eTGp1Tw_2iSL1GtPjAmg4baKjWiwZpQBqPTdFlqov4"}

	response = requests.request("POST", url, files=files, headers=headers)
	print(response.text)
	return response.text