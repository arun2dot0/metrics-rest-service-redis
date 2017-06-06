# metrics-rest-service

Metrics rest service used to integrate with PubNub

#Setup

Get publish and subscribe keys from pubnub.com
and setup in pubnub.MessagingService.java

install and setup redis

Code assumes local setup , if different update in beans.xml

#How to use

PubNub message is sent on call to 
PUT
http://localhost:8080/light?opt=on
http://localhost:8080/light?opt=off




#Integration Raspberry and Grove

It will be used to turn on or off light setup in Raspberry+GrovePi
https://github.com/arun2dot0/PubNubPython.git

#Integration Alexa to this API

And can be integrated to be triggered from Alexa 
https://github.com/arun2dot0/AlexaNodeJS.git

#Next Steps

I also have added Redis to get input data from Rasberry Pi
 - temperature , humidity , light and sound readings 
 and store it . This is part of the next phase and is not integrated
 with raspberry module yet .
 
 