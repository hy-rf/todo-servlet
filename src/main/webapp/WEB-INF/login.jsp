<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form id="login-form" action="/login" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    <input type="submit" value="Login">
</form>
<script>
document.getElementById('login-form').addEventListener('submit',(e)=> {
e.preventDefault()
const form = e.target
let data={}
const formData = new FormData(form)
formData.forEach((value, key) => {
    data[key] = value;
});
console.log(data);
(async ()=> {
const res = await fetch('/login',{
method:'post',
body:JSON.stringify(data)
}).then(res=>res.json())
console.log(res)
})()
})
</script>
</body>
</html>
