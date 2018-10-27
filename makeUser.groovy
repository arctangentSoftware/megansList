import com.megansList.User

//User newUser = new User(
//   username: "arctangentsoftware@gmail.com",
//   password: "@if#4c1NARm!"
//).save(failOnError:true)   

User aUser = User.get(1)
println aUser.username
println aUser.password