<%--************
Create the JSP  For Viewing All of The  Job_Listing table
 Created By Jonathan Beck 4/29/2024
**********--%>
<%@include file="/WEB-INF/learnx/top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Job_Listings</h1>
            <p>There ${Job_Listings.size() eq 1 ? "is" : "are"}&nbsp;${Job_Listings.size()} Job_Listing${Job_Listings.size() ne 1 ? "s" : ""}</p>
            Add Job_Listing   <a href="addJob_Listing">Add</a>
            <c:if test="${Job_Listings.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Job_id</th>
                        <th scope="col">Apply</th>
                        <th scope="col">department_id</th>
                        <th scope="col">featured</th>
                        <th scope="col">position</th>
                        <th scope="col">posted_at</th>
                        <th scope="col">contract</th>
                        <th scope="col">location</th>
                        <th scope="col">job_description</th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Job_Listings}" var="job_listing">
                        <tr>
                            <td>${fn:escapeXml(job_listing.job_id)}</td>
                            <td><a href = "apply-learnx?job_id=${job_listing.job_id}" > Apply </a></td>
                            <td>${fn:escapeXml(job_listing.department.department_id)}</td>
                            <td>${fn:escapeXml(job_listing.featured)}</td>
                            <td>${fn:escapeXml(job_listing.position)}</td>
                            <td>${fn:escapeXml(job_listing.posted_at)}</td>
                            <td>${fn:escapeXml(job_listing.contract)}</td>
                            <td>${fn:escapeXml(job_listing.location)}</td>
                            <td>${fn:escapeXml(job_listing.description)}</td>



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
<%@include file="/WEB-INF/learnx/bottom.jsp"%>

