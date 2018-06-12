<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
Identity by HTML5 UP
html5up.net | @ajlkn
Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
    <title>Identity | ${profile.name}'s resume | ${profile.job}</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--[if lte IE 8]><script src="${routes.host}/assets/js/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="${routes.host}/assets/css/main.css" />
    <!--[if lte IE 9]><link rel="stylesheet" href="${routes.host}/assets/css/ie9.css" /><![endif]-->
    <!--[if lte IE 8]><link rel="stylesheet" href="${routes.host}/assets/css/ie8.css" /><![endif]-->
    <noscript><link rel="stylesheet" href="${routes.host}/assets/css/noscript.css" /></noscript>
</head>
<body class="is-loading">
<!-- Wrapper -->
<div id="wrapper">
    <!-- Main -->
    <section id="main">
        <header>
            <span class="avatar"><img src="${routes.host}${profile.avatar}" alt="${profile.name}" width="122" height="122" /></span>
            <h1>${profile.name}</h1>
            <p>${profile.job}</p>
        </header>
        <footer>
            <ul class="icons">
                <li><a href="${profile.social.twitter}" class="fa-twitter">Twitter</a></li>
                <li><a href="${profile.social.instagram}" class="fa-instagram">Instagram</a></li>
                <li><a href="${profile.social.facebook}" class="fa-facebook">Facebook</a></li>
            </ul>
        </footer>
    </section>
    <!-- Footer -->
    <footer id="footer">
        <ul class="copyright">
            <li>&copy; Ngoc Khuong</li>
            <li>Develop: <a href="https://ngockhuong.com">Ngoc Khuong</a></li>
            <li><a href="${routes.cpanel}">Cpanel</a></li>
        </ul>
    </footer>
</div>
<!-- Scripts -->
<!--[if lte IE 8]><script src="${routes.host}/assets/js/respond.min.js"></script><![endif]-->
<script>
    if ('addEventListener' in window) {
        window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
        document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
    }
</script>
</body>
</html>