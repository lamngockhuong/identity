<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<!--
Identity by HTML5 UP
html5up.net | @ajlkn
Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
    <title>Identity | Cpanel</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--[if lte IE 8]><script src="${routes.host}/assets/js/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="${routes.host}/assets/css/main.css" />
    <!--[if lte IE 9]><link rel="stylesheet" href="${routes.host}/assets/css/ie9.css" /><![endif]-->
    <!--[if lte IE 8]><link rel="stylesheet" href="${routes.host}/assets/css/ie8.css" /><![endif]-->
    <noscript><link rel="stylesheet" href="${routes.host}/assets/css/noscript.css" /></noscript>
    <link rel="stylesheet" href="${routes.host}/assets/css/custom.css" />
</head>
<body class="is-loading">
<!-- Wrapper -->
<div id="wrapper">
    <!-- Main -->
    <section id="main">
        <header>
            <span class="avatar"><img src="${routes.host}${profile.avatar}" alt="${profile.name}" width="122" height="122" /></span>
        </header>
        <h2>Control Panel</h2>
        <form:form method="POST" action="${routes.cpanel}" modelAttribute="profile" enctype="multipart/form-data">
            <div class="field">
                <form:input path="name" placeholder="Name" />
            </div>
            <div class="field">
                <form:input path="job" placeholder="Job" />
            </div>
            <div class="field" style="display: none">
                <input type="file" name="avatar" id="avatar" accept="image/*"/>
            </div>
            <div class="field">
                <textarea name="socials" id="socials" rows="4">${socials}</textarea>
            </div>
            <div class="field">
                <label>But are you a robot?</label>
                <input type="radio" id="robot_yes" name="robot" value="1" checked /><label for="robot_yes">Yes</label>
                <input type="radio" id="robot_no" name="robot" value="0" /><label for="robot_no">No</label>
            </div>
            <ul class="actions">
                <li><button type="submit" class="button">Save</button></li>
            </ul>
        </form:form>
    </section>
    <!-- Footer -->
    <footer id="footer">
        <ul class="copyright">
            <li>&copy; Ngoc Khuong</li>
            <li>Develop: <a href="https://ngockhuong.com">Ngoc Khuong</a></li>
            <li><a href="${routes.home}">Home</a></li>
        </ul>
    </footer>
</div>
<!-- Scripts -->
<script src="${routes.host}/assets/js/jquery-3.3.1.min.js"></script>
<!--[if lte IE 8]><script src="${routes.host}/assets/js/respond.min.js"></script><![endif]-->
<script>
    if ('addEventListener' in window) {
        window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
        document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
    }

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('.avatar img').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $(document).ready(function() {
        $('.avatar').click(function () {
            $('#avatar').click();
        });

        $("#avatar").change(function() {
            readURL(this);
        });
    });
</script>
</body>
</html>