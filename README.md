## Music Streaming RestApi
### Frameworks and Language used:
* Spring
* Spring boot
* Java

### Data Flow
* Controller : 
  * In this Application am used 2 controller
    * UserController
    * AdminController
    
* Service
  * In this Application am used 3 Service
    * UserSerivce
    * AdminsService
    * MusicService
   
* Repository
  * In this Application am used 4 Repository
    * IMusicUserRepository
    * IAdminMusicRepository
    * IUserStatusRepository
    * IMusicRepository
* Database
  * I used Myslq Database In this Application.
 

### Project Summery

* This project is a music streaming service API that allows two types of users: Normal and Admin users. Admin users have the authority to perform CRUD (Create, Read, Update, and Delete) operations on songs, while normal users can only add songs to their playlists and perform CRUD operations on their playlists.

* The API is built using MySQL database to store songs and user playlists, and its IP address of the deployment link must be static to ensure its availability. Additionally, the API uses annotation-based validation to ensure that all user inputs are valid before being processed.

* The project structure includes a controller service and a repository, providing a clear separation of concerns and making the code more modular. Furthermore.

* To ensure data security and user data privacy, normal users cannot create or do CRUD operations on songs, and only Admin users have the necessary permissions to perform these actions. This ensures that the API is both secure and user-friendly.

* Overall, this project provides a scalable and secure API for music streaming services that allows users to manage their playlists effectively while ensuring the safety of their data.
