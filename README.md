# RentAGym

I worked on this project with 3 other people in the Software Engineering I course at UIC.
The main goal was to create a prototypical Android app that could be used by buyers and sellers of gym equipment during the coronavirus pandemic.
The specifications were created by a previous 4 man group in the class, which can be viewed in totality in "Specifications.pdf."
My group's final report detailing our deliverables can be found in "Final Report.pdf."
Our app was coded completely in Java with Android Studio.

## What I worked on

### Seller

I primarily worked in the "Seller" subpackage. 
I made the UI features of the app operative with our Firestore database.
This included support for logging in and registering.
It also included setting up the Seller_Chat.java activity, which allows the Seller to send direct messages to any of their Customers.
I also included a stub profile screen with a rudimentary auto-complete for searching for workouts.

### Testing

I included 18 Espresso tests for the screens that show up when the user logs in as a Seller.
I also included 17 Espresso tests for the screens that show up when the user logs in as a Customer.
The RecyclerView in both the Customer and Seller's chats are tested.
There are many tests to make sure fragments and the bottom navigation menu work as intended.
