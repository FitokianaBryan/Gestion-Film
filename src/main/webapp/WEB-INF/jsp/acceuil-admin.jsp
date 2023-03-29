<%@ page import="com.aina.spring_mvc.model.FilmSery" %>
<%@ page import="java.util.List" %>
<%@ page import="com.aina.spring_mvc.model.FilmSery" %>
<%@ page import="com.aina.spring_mvc.model.PlanningScene" %>
<%@ page import="com.aina.spring_mvc.model.*" %>

<%  List<PlanningScene> planningScenes = (List<PlanningScene>) request.getAttribute("planningScenes");
    List<Plateau> listeplateaux = (List<Plateau>)request.getAttribute("listeplateaux");
    List<Acteur> listeacteurs = (List<Acteur>)request.getAttribute("listeacteurs");
    List<PlanningScene> nonvalide = (List<PlanningScene>)request.getAttribute("listenonvalide");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Tables / General - NiceAdmin Bootstrap Template</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="${pageContext.request.contextPath}/assets/img/favicon.png" rel="icon">
    <link href="${pageContext.request.contextPath}/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">

    <!-- =======================================================
    * Template Name: NiceAdmin - v2.5.0
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="toAccueilAdmin" class="logo d-flex align-items-center">
            <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="">
            <span class="d-none d-lg-block">NiceAdmin</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
        <form class="search-form d-flex align-items-center" method="POST" action="#">
            <input type="text" name="query" placeholder="Search" title="Enter search keyword">
            <button type="submit" title="Search"><i class="bi bi-search"></i></button>
        </form>
    </div><!-- End Search Bar -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">

            <li class="nav-item d-block d-lg-none">
                <a class="nav-link nav-icon search-bar-toggle " href="#">
                    <i class="bi bi-search"></i>
                </a>
            </li><!-- End Search Icon-->

            <li class="nav-item dropdown">

                <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                    <i class="bi bi-bell"></i>
                    <span class="badge bg-primary badge-number">4</span>
                </a><!-- End Notification Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
                    <li class="dropdown-header">
                        You have 4 new notifications
                        <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-exclamation-circle text-warning"></i>
                        <div>
                            <h4>Lorem Ipsum</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>30 min. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-x-circle text-danger"></i>
                        <div>
                            <h4>Atque rerum nesciunt</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>1 hr. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-check-circle text-success"></i>
                        <div>
                            <h4>Sit rerum fuga</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>2 hrs. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="notification-item">
                        <i class="bi bi-info-circle text-primary"></i>
                        <div>
                            <h4>Dicta reprehenderit</h4>
                            <p>Quae dolorem earum veritatis oditseno</p>
                            <p>4 hrs. ago</p>
                        </div>
                    </li>

                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li class="dropdown-footer">
                        <a href="#">Show all notifications</a>
                    </li>

                </ul><!-- End Notification Dropdown Items -->

            </li><!-- End Notification Nav -->

            <li class="nav-item dropdown">

                <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
                    <i class="bi bi-chat-left-text"></i>
                    <span class="badge bg-success badge-number">3</span>
                </a><!-- End Messages Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
                    <li class="dropdown-header">
                        You have 3 new messages
                        <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/assets/img/messages-1.jpg" alt="" class="rounded-circle">
                            <div>
                                <h4>Maria Hudson</h4>
                                <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                                <p>4 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/assets/img/messages-2.jpg" alt="" class="rounded-circle">
                            <div>
                                <h4>Anna Nelson</h4>
                                <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                                <p>6 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="message-item">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/assets/img/messages-3.jpg" alt="" class="rounded-circle">
                            <div>
                                <h4>David Muldon</h4>
                                <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                                <p>8 hrs. ago</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li class="dropdown-footer">
                        <a href="#">Show all messages</a>
                    </li>

                </ul><!-- End Messages Dropdown Items -->

            </li><!-- End Messages Nav -->

            <li class="nav-item dropdown pe-3">

                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                    <img src="${pageContext.request.contextPath}/assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
                    <span class="d-none d-md-block dropdown-toggle ps-2">K. Anderson</span>
                </a><!-- End Profile Iamge Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li class="dropdown-header">
                        <h6>Kevin Anderson</h6>
                        <span>Web Designer</span>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                            <i class="bi bi-person"></i>
                            <span>My Profile</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                            <i class="bi bi-gear"></i>
                            <span>Account Settings</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">
                            <i class="bi bi-question-circle"></i>
                            <span>Need Help?</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="deconnexionadmin">
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Sign Out</span>
                        </a>
                    </li>

                </ul><!-- End Profile Dropdown Items -->
            </li><!-- End Profile Nav -->

        </ul>
    </nav><!-- End Icons Navigation -->

</header><!-- End Header -->


<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link collapsed" href="listeplateau">
                <i class="bi bi-grid"></i>
                <span>Listes des plateaux</span>
            </a>
            <a class="nav-link collapsed" href="planning">
                <i class="bi bi-grid"></i>
                <span>Arranger un planning</span>
            </a>
            <a class="nav-link collapsed" href="toPermuter">
                <i class="bi bi-grid"></i>
                <span>Permuter un planning</span>
            </a>
        </li><!-- End Dashboard Nav -->



        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#forms-nav" data-bs-toggle="collapse">
                <i class="bi bi-journal-text"></i><span>Options</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="forms-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="listefilms">
                        <i class="bi bi-circle"></i><span>Liste des films</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Forms Nav -->


    </ul>

</aside><!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Liste des films</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item">Films</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">

                <%
                    String succes = (String) request.getAttribute("succes");
                    if (succes != null) {
                %>
                <p class="alert-danger"><%= succes %> </p>
                <%
                    }
                %>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Indisponibilité d'un plateau</h5>
                        <form class="row g-3" action="newIndispoPlateau" method="POST">
                            <div class="col-md-12">
                                <div class="form-floating">
                                    <select class="form-select"  name="plateau"  id="floatingSelect" aria-label="State">
                                        <%--LISTE DE SPLATEAUX--%>
                                        <% for(Plateau plateau : listeplateaux) { %>
                                            <option value="<%= plateau.getId()%>"><%= plateau.getNomplateau()%></option>
                                        <% } %>
                                    </select>
                                    <label for="floatingSelect">Plateau</label>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-floating">
                                    <input type="datetime-local"  name="datedebut" class="form-control" id="floatingPassword">
                                    <label for="floatingPassword">Du</label>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-floating">
                                    <input type="datetime-local"  name="datefin" class="form-control" id="floatingPassword">
                                    <label for="floatingPassword">Au</label>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Enregistrer</button>
                                </div>
                            </div>
                        </form>
                        <h5 class="card-title">Indisponibilité d'un acteur</h5>
                        <form class="row g-3" action="newIndispoActeur" method="POST">
                            <div class="col-md-12">
                                <div class="form-floating">
                                    <select class="form-select"  name="acteur"  id="floatingSelect" aria-label="State">
                                        <%--LISTE DES ACTEURS--%>
                                        <% for(Acteur acteur : listeacteurs) { %>
                                            <option value="<%= acteur.getId()%>"><%= acteur.getPrenom()%> <%= acteur.getNom()%></option>
                                        <% } %>
                                    </select>
                                    <label for="floatingSelect">Acteur</label>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-floating">
                                    <input type="datetime-local"  name="datedebut" class="form-control" id="floatingpassword">
                                    <label for="floatingPassword">Du</label>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-floating">
                                    <input type="datetime-local"  name="datefin" class="form-control" id="floatingpassword">
                                    <label for="floatingPassword">Au</label>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Enregistrer</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Validation/Refus d'une scène</h5>
                        <form class="row g-3" action="validerPlanningScene" method="POST">
                            <div class="col-md-12">
                                <div class="form-floating" id="floatdisapeared">
                                    <input type="datetime-local"  name="datevalidation" class="form-control floatingvalide1" id="floatingvalide">
                                    <label for="floatingvalide">Au</label>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-floating">
                                    <select class="form-select"  name="validation"  id="floatingetat" aria-label="State">
                                        <option value="11">Valider</option>
                                        <option value="1">Refuser</option>
                                    </select>
                                    <label for="floatingetat">Validation</label>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary">Valider</button>
                                </div>
                            </div>
                        <h5 class="card-title">Liste des planning scene non valide</h5>

                        <!-- Default Table -->
                        <table class="table" style="min-width: 70%;">
                            <thead>
                            <tr>
                                <th scope="col">Identifiant</th>
                                <th scope="col">idScene</th>
                                <th scope="col">Date debut</th>
                                <th scope="col">Date fin</th>
                            </tr>
                            </thead>
                            <tbody>
                            <% for (int i=0;i<planningScenes.size();i++){ %>
                            <tr>
                                <th scope="row"><%=planningScenes.get(i).getId()%></th>
                                <td><%=planningScenes.get(i).getIdscene()%></td>
                                <td><%=planningScenes.get(i).getDatedebut()%></td>
                                <td><%=planningScenes.get(i).getDatefin()%></td>
                                <td><input type="checkbox" name="id" value=<%= planningScenes.get(i).getIdscene()%>></td>
                            </tr>
                            <% } %>
                            </tbody>
                        </table>
                        <!-- End Default Table Example -->

                        <h5 class="card-title">Liste des planning scene refusés</h5>

                        <!-- Default Table -->
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Identifiant</th>
                                <th scope="col">idScene</th>
                                <th scope="col">Date debut</th>
                                <th scope="col">Date fin</th>
                            </tr>
                            </thead>
                            <tbody>
                            <% for (int i=0;i<nonvalide.size();i++){ %>
                            <tr>
                                <th scope="row"><%=nonvalide.get(i).getId()%></th>
                                <td><%=nonvalide.get(i).getIdscene()%></td>
                                <td><%=nonvalide.get(i).getDatedebut()%></td>
                                <td><%=nonvalide.get(i).getDatefin()%></td>
                                <td><a href="validerPlanningScene/<%= nonvalide.get(i).getId() %>">valider</a></td>
                            </tr>
                            <% } %>
                            </tbody>
                        </table>
                        <!-- End Default Table Example -->
                    </div>
                </div>
                </form>
            </div>
        </div>
    </section>

</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights Reserved
    </div>
    <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
    </div>
</footer><!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<script src="${pageContext.request.contextPath}/assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/chart.js/chart.umd.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/echarts/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/quill/quill.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<script>
    function replace(str, start, end, replace) {
        return str.substring(0,start)+replace+str.substring(end);
    }
    function toggle () {
        const select = document.getElementById("floatingetat");
        const input = document.querySelector(".floatingvalide1");
        if(select.value === "1") {
            const now = new Date();
            const hour = now.getHours().toString().padStart(2, "0");
            const datenow = now.toISOString().slice(0,16);
            const real = replace(datenow,11,13,hour);
            document.getElementById("floatdisapeared").style.display = "none";
        }
        else if(select.value === "11") {
            input.value = "";
            document.getElementById("floatdisapeared").style.display = "block";
        }
    }
    document.getElementById("floatingetat").addEventListener("change",toggle);
</script>

</body>

</html>