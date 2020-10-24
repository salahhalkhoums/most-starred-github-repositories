# Most Starred Github Repositories



I have made this small Android app as part of the Mobile Coding Challenge using Java.
It lists the most starred Github repos that were created in the last 30 days using the Github API.

# Features

  - The app lists the 20 most starred Github repositories at first. 
  - Pagination: each time we reach the bottom of the list, 20 more repositories will be loaded and so on.
  - Each row includes:
    - Repository name
    - Repository description
    - Numbers of stars for the repo.
    - Username of the owner.
    - Avatar of the owner



# How to use
 -  Open the app and scroll :D
# Preview
![Image of Yaktocat](https://user-images.githubusercontent.com/45936385/97087346-45759e00-1621-11eb-8dcc-4ea14177716d.PNG)

# Libraries
- **Retrofit**: This libarary turns an HTTP API into a Java interface, which is crucial in this app.
- **RecyclerView**: The best listing view for http requests, as it allows the infinite scroll we are needing for this app.
- **Picasso**: to convert the users avatar url into an image in the app.
