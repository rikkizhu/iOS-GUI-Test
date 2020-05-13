#!/bin/bash

node /Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js &
rm -r allure-results
rm -r allure-report
mvn clean test -DsuiteXmlFile=testng.xml
sleep 3
pid=$(ps -ef | grep 'appium/build/lib/main.js' | grep -v grep | awk '{print $2}')
kill -9 $pid
##直接打开测试报告
#allure serve allure-results
##生成 index.html 文件，消息通知
allure generate allure-results -o allure-report
curl 'https://oapi.dingtalk.com/robot/send?access_token=***REMOVED***' \
  -H 'Content-Type: application/json' \
  -d '{
      "msgtype": "markdown",
      "markdown": {
      "title":"iOS 自动化",
      "text": "iOS GUI 自动化执行完成,请及时查看[测试报告](http://192.168.120.143:8080)"
             }
        }'

#定时跑，并发送消息到钉钉，测试报告通过index.html查看
#source /etc/profile
#source ~/.bash_profile
#
#time=$(date "+%Y-%m-%d %H:%M:%S")
#echo "${time}"
#
#cd /Users/***REMOVED***/Desktop/automation/test-ios
#
#node /Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js &
#rm -r allure-results
#rm -r allure-report
#mvn clean test -DsuiteXmlFile=testng.xml
#sleep 3
#pid=$(ps -ef | grep 'appium/build/lib/main.js' | grep -v grep | awk '{print $2}')
#kill -9 $pid
#
#allure generate allure-results -o allure-report
#
#curl 'https://oapi.dingtalk.com/robot/send?access_token=***REMOVED***' \
#  -H 'Content-Type: application/json' \
#  -d '{
#      "msgtype": "markdown",
#      "markdown": {
#      "title":"iOS 自动化",
#      "text": "iOS GUI 自动化执行完成,请及时查看[测试报告](http://192.168.120.143:8080)"
#             }
#        }'
