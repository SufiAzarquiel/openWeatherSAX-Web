<%@page import="util.MathUtil"%>
<%@page import="util.StringUtil"%>
<%@page import="model.Intervalo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="handler.WebHandler" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!doctype html>
        <html lang="en">

        <head>
            <title>OpenWeather</title>
            <!-- Required meta tags -->
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

            <!-- Bootstrap CSS v5.2.1 -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
                crossorigin="anonymous">

        </head>

        <body>
            <main>
                <%
                WebHandler wh =new
                    WebHandler("https://api.openweathermap.org/data/2.5/forecast?q=Toledo,es&mode=xml&APPID=601c9db344b44f9774ef76a4c07979b1&lang=sp");
                ArrayList<Intervalo> intervalos = wh.parsear();
                    %>
                    <div class="container shadow">
                        <div class="row justify-content-center">
                        <%
							for (Intervalo intervalo : intervalos) {
						%>
                            <div class="col-lg-6">
                                <div class="card mt-4">
                                    <div class="row rounded m-3">	
                                        <div class="col-4 bg-primary rounded-3 d-flex align-items-center"><img src="https://openweathermap.org/img/wn/<%=intervalo.getSimbolo()%>.png"
                                                class="card-img" alt="..."></div>
                                        <div class="col-8">
                                            <div class="card-body">
                                                <p class="card-text h1"><%=StringUtil.acortaHora(intervalo.getHoraInicio())%> - <%=StringUtil.acortaHora(intervalo.getHoraFinal())%></p>
                                                <p class="card-text"><strong>Cielo: </strong>
                                                <%=intervalo.getCielo()%></p>
                                                <p class="card-text"><strong>Lluvia: </strong>
                                                <%=intervalo.getPrecipitacion()%>%</p>
                                                <p class="card-text"><strong>Mínima: </strong>
                                                <%=MathUtil.redondear(intervalo.getTemperaturaMinima())%>ºC</p>
                                                <p class="card-text"><strong>Máxima: </strong>
                                                <%=MathUtil.redondear(intervalo.getTemperaturaMaxima())%>ºC</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <%
							}
						%>
                        </div>
                    </div>
            </main>
            <!-- Bootstrap JavaScript Libraries -->
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
                integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
                crossorigin="anonymous">
                </script>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
                integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
                crossorigin="anonymous">
                </script>
        </body>

        </html>