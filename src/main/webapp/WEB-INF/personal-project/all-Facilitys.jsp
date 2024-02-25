<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
  <div class="row">
    <div class="col-12">
      <h1>All Roller Facilitys</h1>
      <p>There ${Facilitys.size() eq 1 ? "is" : "are"}&nbsp;${Facilitys.size()} Facilitys${Facilitys.size() ne 1 ? "s" : ""}</p>
      <c:if test="${Facilitys.size() > 0}">
        <div class="table-responsive"><table class="table table-bordered">
          <thead>
          <tr>
            <th scope="col">Facility_ID</th>
            <th scope="col">Name</th>
            <th scope="col">Addresss</th>
            <th scope="col">City</th>
            <th scope="col">State</th>
            <th scope="col">Zip</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${Facilitys}" var="facility">
            <tr>
              <td>${facility.facility_ID}</td>
              <td>${facility.name}</td>
              <td>${facility.addresss}</td>
              <td>${facility.city}</td>
              <td>${facility.state}</td>
              <td>${facility.zip}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
        </div>
      </c:if>
    </div>
  </div>
</div>
</main>
<%@include file="/WEB-INF/personal-project/personal_bottom.jsp"%>