<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Baseball Players</h1>
            <p>There ${Players.size() eq 1 ? "is" : "are"}&nbsp;${Players.size()} Player${Players.size() ne 1 ? "s" : ""}</p>
            <div class = "container">
                <form method="post" action="${appURL}/api_home" id = "searchPlayer" >
                    <!-- Player_ID -->
                    <div class ="row" id = "row0">
                        <label for="inputplayerPlayer_ID" class="form-label">Search For Player By ID (ex 676265)</label>
                        <div class="input-group input-group-lg">
                            <input type="text" class="<c:if test="${not empty results.playerPlayer_IDerror}">is-invalid</c:if> form-control border-0 bg-light rounded-end ps-1" placeholder="Player_ID" id="inputplayerPlayer_ID" name="inputplayerPlayer_ID" value="${fn:escapeXml(results.Player_ID)}">
                            <c:if test="${not empty results.playerPlayer_IDerror}">
                                <div class="invalid-feedback">${results.playerPlayer_IDerror}</div>
                            </c:if>
                        </div>
                    </div>
                    <div class="align-items-center mt-0">
                        <div class="d-grid"><button class="btn btn-orange mb-0" type="submit">Search Player  </button></div>

                    </div>
                </form>
            </div>
            <c:if test="${Players.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>

                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Age</th>
                        <th scope="col">Height</th>
                        <th scope="col">Weight</th>
                        <th scope="col">Position</th>
                        <th scope="col">Bat (L/R)</th>
                        <th scope="col">Throw (L/R)</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Players}" var="player">
                        <tr>
                            <td>${fn:escapeXml(player.firstName)}</td>
                            <td>${fn:escapeXml(player.lastName)}</td>
                            <td>${fn:escapeXml(player.currentAge)}</td>
                            <td>${fn:escapeXml(player.height)}</td>
                            <td>${fn:escapeXml(player.weight)}</td>
                            <td>${fn:escapeXml(player.position)}</td>
                            <td>${fn:escapeXml(player.batSide)}</td>
                            <td>${fn:escapeXml(player.throwSide)}</td>


                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </div>
            </c:if>
        </div>
    </div>
</div>
<footer>



</footer>







    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="js/jquery.validate.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    <script src="js/budget/site.js"></script>


</body>


</html>
