# InMobiHack

InMobi Hackathon 2015

Inspiration

We see many friends of ours who've come into this habit of smoking, some cases so extreme that they have no choice but to enroll themselves into rehab centers to get cured. This app aims to help those who are earlier on in the path to quitting smoking.

How it works

Most people today are perpetually on their smartphones. And smokers who are early on in their quitting stage exhibit telltale signs of physical behavior. We have therefore used the accelerometer sensors to aid in our hack. The android app has 3 criteria that it uses to check before it does what it does.

 - The first criteria is repetitive shaking of the cellphone upto a threshold value (we have set it at a value of 15).

 - The second criteria is deletion of characters while entering the "key" which certifies the normal state of the person. If the person performs a deletion of more than 5 characters to enter the 9-character-key, the mechanism is triggered.

 - The third and final criteria is the incorrect entering of the key, which is a sure sign for, again, the mechanism to be triggered. 

> SO. WHAT IS THE MECHANISM???? A message is sent to one of the wanting-to-quit-smoker's trusted contacts (currently hardcoded but soon-to-be picked from SQLite Database) signalling whether the 2nd or the 3rd criteria was violated. Regardless, the trusted contact can call up the user upon recieving of said message and provide moral support and ease his condition so that his urge to smoke will be abated for the time being.

But if the user does enter the key correctly - the key here is "Alskdjfhg" ,a well distributed set of characters which will provide just enough difficulty to type for a trembling person - a "toast" popup is sent back to him saying - "You're fine".
