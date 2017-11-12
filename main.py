from flask import Flask,render_template,request
import base64
import os
app = Flask(__name__)

APP_ROOT = os.path.dirname(os.path.abspath(__file__))
# print(APP_ROOT)
# print(UPLOAD_FOLDER)


@app.route('/')
def index():
	return render_template('send_img.html')
@app.route('/upload',methods=['POST'])
def upload():
	target = APP_ROOT+'/static'

	print(target)
	

	for file in request.files.getlist("upload"):
		print(file)
		destination = "/".join([target, 'out.jpg'])
		print("Accept incoming file:", 'out.jpg')
		print(destination)
		file.save(destination)
	import a
	data = a.predict()
	
	return data

if __name__ == '__main__':
	app.run()