## Monster Android Engineer Take-home Assignment

## Summary
The Monster Android Engineer coding challenge consists of building a simple Android app that displays a list of images containing Foxes. The starter project contains an `App` and `Server` module. The `App` module is where you will add your logic, while the `Server` module is a mock server that contains different implementations for performing the network calls you will need. The Fox images will be returned in the form of a `User` object, which contains `name` and `profile_url` fields.

## Your Task
1) Create an adapter that will show a list of fox images in a `RecyclerView`
2) Implement the network calls to retrieve the list of Fox images

You can use 3 different methods from `Server` to implement the network call:
* `getUsers() : Call<List<User>>` a traditional Retrofit callback
* `getDeferredUsers() : Deferred<List<User>>` for Coroutines
* `getInfinitList() : List<User>`  Implement an infinite scroll list! This would require you to keep calling it when the user scrolls past the end.

The app should be developed with industry-accepted architectural and design patterns. Please don't "hack" it together. This doesn't mean you need to cover every edge case. Adding TODO's for smaller cleanup tasks is fine. 

You are allowed to use any third-party frameworks you want to make your life easier but be prepared to justify why you needed/used them and at least have a high level understanding of how they work.

## Project Submission
Once you are ready to submit the project, compress the project folder into a .zip file and email it back.

Please use Git or some other Version Control system to track your progress with useful commit messages, but do not push any code to a **public** remote repository (ex: GitHub). **_Keep this project private and secret._** You should not make this available to anyone other than yourself or the people interviewing you at Monster.  Include your commit messages with your project submission. We just want to see your familiarity with version control :)

## Please Note
Our preference for project network layer implementations: 
1. `getDeferredUsers() : Deferred<List<User>>` for Coroutines
2. `getUsers() : Call<List<User>>` a traditional Retrofit callback

If you have time:
1. `getInfinitList() : List<User>`  Implement an infinite scroll list! This would require you to keep calling it when the user scrolls past the end.

We prefer for you to write in Kotlin, but are open to Java if you are not yet familiar enough with Kotlin. We want you to write the best code you can, just like you would in production; if your Kotlin level isn't production-ready, then please use Java so you can demonstrate your Android knowledge -- you can always learn Kotlin on the job.

You have 48 hours to complete the project from the time you receive it, but it shouldn’t take more than 1 day. If you’re busy, let us know you need an extension on the time. 

When you email the project back to us upon completion, please let us know how many hours you spent on it. 
