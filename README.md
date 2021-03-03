# posFinalSprint
I have not installed any extensions yet but I plan on installing a few quality of life plugins like rainbow brackets for my own benefit.

I was successful at creating a barebones POS app but not in the way I originally intended. My plan was to use the custom control from the repository shared with us and change the format to fit my design idea but I was unable to find out how to reference the buttons inside of the separate objects.
The main roadblock for me this week was finding out how to custom module worked that we were given to play with. I struggled to figure out how to access the object from the main program so I could set listeners to the buttons and have it interact with other objects.
I would like to go through and try to make my own custom controller from scratch and learn to access them from outside of the object. 

All pushes were lost when I had trouble renaming the package so it was all in one when I moved it to a new project, sorry!
  
There is now a second activity that can open and return to the main screen

Working on implementation of SQLite DB at the moment

FINAL REVIEW:
I made a lot of progress in the final sprint by fixing the DB implementation and the dynamic creation/removal/changing of menu options. Unfortunately after the refactor I did not have time in the last sprint to get to the total cost function (coming soon hopefully). I am happy with the current code and the implementation of the SQL database to control the custom controls. 

To run the program, start the emulator and simply go to admin mode using the button, enter a food name and cost in double format (X.YZ) and click add. Similarly for update, enter the food name and you can change the price. This will automatically update the main activity when you return to it with custom controls for everything currently in the database.

Collaborated with: Takamaru Miki
Thanks!
