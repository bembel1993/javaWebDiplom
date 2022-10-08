<%--
  Created by IntelliJ IDEA.
  User: Виталий
  Date: 08.09.2022
  Time: 9:50
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
        color: gold;
        vertical-align: middle;
        margin-left: 5px;
        margin-top: 1px;
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
        width: 300px;

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
                <a href="http://all-free-download.com/free-website-templates/" class="abt1">Services</a>
                <a href="Catalog" class="abt1">Catalog</a>
                <a href="http://all-free-download.com/free-website-templates/" class="abt1">Partners</a>
                <a href="http://all-free-download.com/free-website-templates/" class="abt1">Contacts</a>
                <div class = "abt1"><a href="AddProductInCatalog" class="abt2">LogIn</a>
                <p class = "abt2">/</p>
                <a href="RegistrationServlet" class="abt2">Reg</a>
                </div>
            </div>
        </div>
    </div>

    <div id="searchbg">
        <div id="search">
            <div class="searchtxt">Search Product</div>
            <div id="textfield">
                <form method="POST" action="SearchProduct">
                <input type="text" name="textfield"/>
                <button type="submit" name="search">
                    <a href="${pageContext.request.contextPath }/SearchProduct?action=search&nameprod=${product.nameprod}">
                    Search
                    </a>
                </button>
                </form>
            </div>
            <div id="bullet5"></div>
        </div>
        <div class="welcome">WELCOME ${name} ${surname} to our computer store!</div>
        <a href="registration.jsp" class="readtxtwel">Private office</a>
    </div>
</div>
    <div id="curve">
        <div class="onsale"><h1>NEW ON SALE</h1></div>
    </div>

    <table align="center" bgcolor="#dcffed" border=0 width="800">
        <tr>
            <td colspan="2" align="center"><font size="6"></td>
            <form>
        <tr align="right" valign="bottom">
            <td><font color="Black"><b>${nameprod}</b></font></td>
            <td><font color="Black"><b>Laptop</b></font></td>

        </tr>

        <tr align="right" valign="bottom">
            <td>
                ${photo}
           <!--     <img src="img/samsungs.jpeg" width="600" height="auto">-->
           </td>
            <td>
                <img src="img/prosixteen.png" width="600" height="auto"></td>

        </tr>

        <tr align="left" valign="top">
            <td>
                Display. 6.1 inches. 2340 x 1080 pixels. 120Hz Refresh rate.
                Camera. 50 MP (Triple camera) 10 MP front.
                Hardware. Qualcomm Snapdragon 8 Gen 1. 8GB RAM.
                Storage. 128GB, not expandable.
                Battery. 3700 mAh.
                OS. Android 12. One UI UI.
            </td>
            <td>
                "Vivobook Pro 16X OLED brings you the speed and
                accuracy you need to realize your vision,
                with a 16-inch NanoEdge 4K OLED1 display,
                11th Generation Intel® H Series CPU, and NVIDIA®
                GeForce RTX™ 3050 graphics. The exclusive ASUS DialPad
                gives you precise and intuitive control of your creative tools,
                and the dual-fan cooling design lets you work in undisturbed peace.
                Vivobook Pro 16X OLED unlocks the door to your creative future."
            </td>

        </tr>

        <tr align="right">
            <td><input type="checkbox">$1000</input></td>
            <td><input type="checkbox">$500</input></td>

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
            <td colspan="2" align="center">
                <button type="submit">Order</button>
            </td>
            <td></td>
            <td colspan="2" align="center">
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
