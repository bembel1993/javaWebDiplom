<%--
  Created by IntelliJ IDEA.
  User: Виталий
  Date: 13.09.2022
  Time: 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Computer market</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <link href="imgcss/stylesheet.css" rel="stylesheet" type="text/css" />
</head>
<style>
    table {
        border-spacing: 6px 10px;
    }

    a:link {
        text-decoration: none;
    }

    a:visited {
        text-decoration: none;
    }

    a:hover {
        text-decoration: none;
    }

    a:active {
        text-decoration: none;
    }

    #layout {
        width: 100%;
        height: auto;
        background-color: #FFFFFF;
        margin: auto;
    }

    body {
        margin: 0 auto;
        background-color: white;
    }

    #title {
        background-color: royalblue;
        width: 100%;
        height: 78px;
    }

    #logo {
        width: 260px;
        height: 78px;
    }

    .text {
        font-family: Verdana, Arial, Helvetica, sans-serif;
        font-size: 24px;
        color: #FFFFFF;
        font-weight: bold;
        margin-left: 40px;
        padding-top: 20px;
        width: 30px;
    }

    .text1 {
        font-family: Verdana, Arial, Helvetica, sans-serif;
        font-size: 18px;
        color: #000000;
        font-weight: bold;
        margin-left: 180px;
        width: 30px;
        margin-top: -23px;
    }

    #links {
        width: 509px;
        height: 78px;
        margin-top: -78px;
        margin-left: 265px;
    }

    #arrow {
        width: 510px;
        height: 10px;
        margin-top: 20px;
    }

    #linktext {
        width: 900px;
        height: 30px;
    }
    #linktext2{
        width: 700px;
        height: 30px;
    }

    .abt {
        float: left;
        font-family: Arial, Helvetica, sans-serif;
        font-size: 16px;
        font-weight: bold;
        color: #FFFFFF;
        vertical-align: middle;
        margin-left: 18px;
        margin-top: 7px;

    }

    .abt1 {
        float: left;
        font-family: Arial, Helvetica, sans-serif;
        font-size: 16px;
        font-weight: bold;
        color: #FFFFFF;
        vertical-align: middle;
        margin-left: 38px;
        margin-top: 7px;

    }
    .abt2 {
        float: left;
        font-family: Arial, Helvetica, sans-serif;
        font-size: 16px;
        font-weight: bold;
        color: #FFFFFF;
        vertical-align: middle;
        margin-left: 100px;
        margin-top: 7px;

    }

    #search {
        float: left;
        background-image: url("searchcurve.jpg");
        width: 304px;
        height: 122px;
        background-repeat: no-repeat;
    }

    #searchbg {
        width: 775px;
        height: 122px;
    }

    .searchtxt {
        font-family: Arial, Helvetica, sans-serif;
        font-size: 14px;
        font-weight: bold;
        color: #000000;
        margin-left: 50px;
        padding-top: 20px;

    }

    #textfield {
        margin-left: 50px;
        margin-top: 20px;
    }

    #bullet5 {
        background-image: url("searcharrow.jpg");
        width: 29px;
        height: 30px;
        background-repeat: no-repeat;
        margin-left: 245px;
        margin-top: -28px;
    }

    .welcome {
        font-family: Arial, Helvetica, sans-serif;
        font-size: 30px;
        font-weight: bold;
        color: #C67108;
        margin-left: 330px;
        width: 700px;
        padding-top: 10px;

    }

    #curve {
        background-image: url("curve.jpg");
        width: 775px;
        height: 79px;
        background-repeat: no-repeat;
    }

    .onsale {
        font-family: Arial, Helvetica, sans-serif;
        font-size: 18px;
        font-weight: normal;
        color: #8ea11f;
        margin-left: 550px;

    }

    .readtxtwel {
        margin-left: 30px;
        font-family: Arial, Helvetica, sans-serif;
        font-size: 10px;
        font-weight: bold;
        color: #8ea505;
        text-decoration: underline;
        margin-top: -12px;
    }

    .content{
        position: relative;
        height: 40px;
        padding: 30px 40px;
        background-color: royalblue;
    }

</style>
<body>
<div id="layout">
    <div id="title">
        <div id="logo">
            <a href="WelcomeClassMenu">
                <div class="text">Computer</div>
                <div class="text1">Store</div>
            </a>
        </div>
        <div id="links">
            <div id="linktext"><a href="http://all-free-download.com/free-website-templates/" class="abt">About us</a>
                <a href="http://all-free-download.com/free-website-templates/" class="abt1">Services</a> <a
                        href="Catalog" class="abt1">Catalog</a> <a
                        href="http://all-free-download.com/free-website-templates/" class="abt1">Partners</a> <a
                        href="http://all-free-download.com/free-website-templates/" class="abt1">Contacts</a>
                <a href="LoginServlet" class="abt1">LogIn</a>
                <a href="AddProductInCatalog" class="abt1">Add product in catalog</a>
            </div>
        </div>
    </div>

    <div id="searchbg">
        <div id="search">
            <div class="searchtxt">Search Product</div>
            <div id="textfield">
                <input type="text" name="textfield"/>
                <button type="submit" name="search">Search</button>
            </div>
            <div id="bullet5"></div>
        </div>
        <div class="welcome">WELCOME ${name} to our computer store!</div>
        <a href="registration.jsp" class="readtxtwel">Private office</a>
    </div>
</div>
<div id="curve">
    <div class="onsale"><h1>ON SALE</h1></div>
</div>

<table align="center" bgcolor="#f5fffa" border=0 width="800">
    <tr>
        <td colspan="2" align="center"><font size="6"></td>
        <form>
    <tr align="right" valign="bottom">
        <td><font color="Black"><b>Quadrocopter</b></font></td>
        <td><font color="Black"><b>Electric skateboard</b></font></td>
        <td><font color="Black"><b>Headphones</b></font></td>
        <td><font color="Black"><b>Keyboard</b></font></td>
        <td><font color="Black"><b>Tablete</b></font></td>
    </tr>

    <tr align="right" valign="bottom">
        <td>
            <img src="img/goods1.png" width="100" height="80"></td>
        <td>
            <img src="img/goods2.png" width="100" height="50"></td>
        <td>
            <img src="img/goods3.png" width="80" height="80"></td>
        <td>
            <img src="img/goods4.png" width="100" height="50"></td>
        <td>
            <img src="img/goods5.png" width="50" height="80"></td>
    </tr>

    <tr align="right">
        <td><input type="checkbox">$1000</input></td>
        <td><input type="checkbox">$500</input></td>
        <td><input type="checkbox">$35</input></td>
        <td><input type="checkbox">$40</input></td>
        <td><input type="checkbox">$200</input></td>
    </tr>

    <tr>
        <td colspan="6" align="center">
            <h3><font color="Black">Delivery address</font></h3>
            <textarea name="comment" cols="50" rows="3"></textarea>
        </td>
    </tr>

    <tr>
        <td colspan="6" align="center" valign="bottom">
            <h3><font color="Black">Payment</font></h3>
            <input type="radio" name="s">Cash to the courier</input>
            <input type="radio" name="s">Bank transfer</input>
        </td>
    </tr>

    <tr>
        <td colspan="6" align="center">
            <h3><font color="Black">Site opinion</font></h3>
            <select name="note">
                <option value="o">great</option>
                <option value="h">good</option>
                <option value="p">indifferently</option>
                <option value="pl">bad</option>
                <option value="spl">very bad</option>
            </select>
        </td>
    </tr>

    <tr>
        <td colspan="6" align="center">
            <h3><font color="Black">Wishes</font></h3>
            <textarea name="comment" cols="70" rows="3"></textarea>
        </td>
    </tr>

    <tr width="20%">
        <td colspan="2" align="right">
            <button type="submit">Order</button>
        </td>
        <td></td>
        <td colspan="2" align="left">
            <button type="reset" name="res">Clear</button>
        </td>
        <td width="8%"></td>
    </tr>

    </form>
</table>

<div class="content">
    <div >CALL OUR CENTER !</div>
    <div >1-800-123-45678</div>
    <div >1-800-222-45678</div>
</div>
</div>
</div>
</body>
</html>
