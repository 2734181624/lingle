<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>

<head>
    <style>
        * {
            text-decoration: none;
            margin: 0;
        }

        .top {
            background: yellow;
        }

      /*  .dropbtn {
            background-color: white;
            color: black;
            padding: #px;
            font-size: xx-large;
            border: none;
        }

        .dropdown {
            position: relative;
            display: inline-block;
            float: right;
            margin-top: 0px;
            margin-right: 30px;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: lightgrey;
            min-width: #px;
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: #px #px;
            font-size: xx-large;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {
            background-color: white;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown:hover .dropbtn {
            background-color: grey;
        }*/

        .bodyindex {
            position: relative;
            width: 100%;
            height: 680px;
            background-image: url(img/f08603687b3409addf544476b1769e40.jpg);
        }

        .bodyindex .cut {
            position: absolute;
            top: 100px;
            padding: 3px;
            background: whitesmoke;
            width: 600px;
            height: 450px;
            margin-left: 30%;
        }

        .bodyindex .cut .control {
            margin-top: 30px;
            margin-left: 200px;
        }

        .bodyindex .cut .show {
            margin-top: 50px;
            margin-left: 200px;
        }

        .bodyindex .cut .show > div {
            display: none;

        }

        .bottom {
            text-align: center;
            background: aliceblue;
        }
    </style>
    <meta charset="UTF-8">
    <title></title>
</head>

<body>
<div class="top">
    <img src="img/17.png" height="50px">
</div>
<div class="bodyindex">
    <div class="cut">
        <div class="control">
            <button>登录</button>
            <button>注册</button>
        </div>
        <div class="show">
            <div id="show1">
                <form name="userinsert" action="/Online_Account_Book_war_exploded/indexInsertHomeServlet" mathod="post">
                    账号<input class="input_1" id="username1" size=15 name="username" placeholder=账号><br/><br/>
                    密码<input class="input_1" id="password1" type=text size=15 name="password" placeholder=密码><br/><br/>
                    <input class="input_2" type="submit" value="登录"/>
                </form>
            </div>
            <div id="show2">
                <form name="useradd" action="/Online_Account_Book_war_exploded/indexAddUserServlet" mathod="post">
                    账号<input class="input_1" id="userid" size=15 name="userid" placeholder=账号><br/><br/>
                    电话号码<input class="input_1" id="phonenumber" type=text size=15 name="userphonenumber"
                               placeholder=电话号码><br/><br/>
                    姓名<input class="input_1" id="username" size=15 name="username" placeholder=姓名><br/><br/>
                    密码<input class="input_1" id="password" type=text size=15 name="userpassword"
                             placeholder=密码><br/><br/>
                    <input class="input_2" type="submit" value="注册账号"/>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="bottom">
    <br/>
    <h3>清枫（北京）科技有限公司 2015-2020 © All Rights Reserved.</h3>
    <h3>京公网安备11010502034222号 | 京ICP备15018522号-6 | 京网文[2017]8080-895号 | 京ICP证B2-20180020</h3>
    <h3>违法和不良信息举报电话：010-84158300　举报邮箱：jubao@xiaoheihe.cn</h3>
    <br/>
</div>
<script type="text/javascript">
    var btn = document.querySelectorAll('.bodyindex .cut .control>button');
    var show = document.querySelectorAll('.show>div');
    for (var i = 0; i < btn.length; i++) {
        //				把当前按钮的下标保存，按下按钮对应显示下标一致的盒子，其它盒子隐藏
        btn[i].index = i;
        btn[i].onclick = function () {
            //					遍历每个按钮样式清空
            //					遍历每个盒子隐藏
            for (var j = 0; j < btn.length; j++) {
                btn[j].className = ''
                show[j].style.display = 'none';
            }
            //					this表示当前按钮
            this.className = 'active'
            //					盒子显示按钮下标的那个盒子，this。index是开始时保存的按钮下标
            show[this.index].style.display = 'block'
        }
    }
</script>
</body>
</html>