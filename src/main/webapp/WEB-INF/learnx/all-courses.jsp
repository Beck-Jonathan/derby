<jsp:include page="/WEB-INF/learnx/top.jsp"></jsp:include>

<main>
    <!-- =======================
Page content START -->
    <section class="pb-0 py-sm-5">
        <div class="container">

            <div class="row">
                <!-- Main content START -->
                <div class="col-xl-9 col-xxl-8">

                    <!-- Course list START -->
                    <div class="row g-4">
                        <c:forEach items ="${courses}" var ="course">
                        <!-- Card list START -->
                        <div class="col-12">

                            <div class="card shadow overflow-hidden p-2">
                                <div class="row g-0">
                                    <div class="col-md-5 overflow-hidden">
                                        <img src="assets/images/courses/4by3/06.jpg" class="rounded-2" alt="Card image">
                                    </div>
                                    <div class="col-md-7">
                                        <div class="card-body">
                                            <!-- Badge and rating -->
                                            <div class="d-flex justify-content-between align-items-center mb-2">
                                                <!-- Badge -->
                                                <a href="#" class="badge text-bg-primary mb-2 mb-sm-0">${course.categoryName}</a>
                                            </div>

                                            <!-- Title -->
                                            <h5 class="card-title"><a href="#">${course.name}</a></h5>
                                            <p class="text-truncate-2 d-none d-lg-block">${course.description}</p>

                                            <!-- Info -->
                                            <ul class="list-inline">
                                                <li class="list-inline-item h6 fw-light"><i class="fas fa-signal text-success me-2"></i>${course.level}</li>
                                            </ul>

                                            <!-- Teacher and Enroll -->
                                            <div class="d-sm-flex justify-content-sm-between align-items-center">
                                                <!-- Teacher -->
                                                <div class="d-flex align-items-center">
                                                    <p class="mb-0 ms-2">${course.teacherFirstName}&nbsp${course.teacherLastName}</p>
                                                </div>
                                                <!-- Enroll -->
                                                <div class="mt-3 mt-sm-0">
                                                    <a href="#" class="btn btn-dark">Enroll</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                        <!-- Card list END -->

                    </div>
                    <!-- Course list END -->

                </div>
                <!-- Main content END -->

                <!-- Right sidebar START -->
                <div class="col-lg-3 col-xxl-4">
                    <!-- Responsive offcanvas body START -->
                    <div class="offcanvas-xl offcanvas-end" tabindex="-1" id="offcanvasSidebar">
                        <div class="offcanvas-header bg-light">
                            <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Advance Filter</h5>
                            <button  type="button" class="btn-close" data-bs-dismiss="offcanvas" data-bs-target="#offcanvasSidebar" aria-label="Close"></button>
                        </div>
                        <div class="offcanvas-body p-3 p-xl-0">
                            <form>
                                <!-- Category START -->
                                <div class="card card-body shadow p-4 mb-4">
                                    <!-- Title -->
                                    <h4 class="mb-4">Category</h4>
                                    <div class="row">
                                        <!-- Category group -->
                                        <div class="col-xxl-6">
                                            <!-- Checkbox -->
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault9">
                                                <label class="form-check-label" for="flexCheckDefault9">All</label>
                                            </div>
                                            <!-- Checkbox -->
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault10">
                                                <label class="form-check-label" for="flexCheckDefault10">Development</label>
                                            </div>
                                            <!-- Checkbox -->
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault11">
                                                <label class="form-check-label" for="flexCheckDefault11">Design</label>
                                            </div>
                                            <!-- Checkbox -->
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault12">
                                                <label class="form-check-label" for="flexCheckDefault12">Accounting</label>
                                            </div>
                                            <!-- Checkbox -->
                                            <div class="form-check">
                                                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault17">
                                                <label class="form-check-label" for="flexCheckDefault17">Translation</label>
                                            </div>
                                        </div>

                                    </div><!-- Row END -->
                                </div>
                                <!-- Category END -->

                                <!-- Skill level START -->
                                <div class="card card-body shadow p-4 mb-4">
                                    <!-- Title -->
                                    <h4 class="mb-3">Skill level</h4>
                                    <ul class="list-inline mb-0">
                                        <!-- Item -->
                                        <li class="list-inline-item mb-2">
                                            <input type="radio" class="btn-check" id="btn-check-12">
                                            <label class="btn btn-light btn-primary-soft-check" for="btn-check-12">All levels</label>
                                        </li>
                                        <!-- Item -->
                                        <li class="list-inline-item mb-2">
                                            <input type="radio" class="btn-check" id="btn-check-9">
                                            <label class="btn btn-light btn-primary-soft-check" for="btn-check-9">Beginner</label>
                                        </li>
                                        <!-- Item -->
                                        <li class="list-inline-item mb-2">
                                            <input type="radio" class="btn-check" id="btn-check-10">
                                            <label class="btn btn-light btn-primary-soft-check" for="btn-check-10">Intermediate</label>
                                        </li>
                                        <!-- Item -->
                                        <li class="list-inline-item mb-2">
                                            <input type="radio" class="btn-check" id="btn-check-11">
                                            <label class="btn btn-light btn-primary-soft-check" for="btn-check-11">Advanced</label>
                                        </li>
                                    </ul>
                                </div>
                                <!-- Skill level END -->
                            </form><!-- Form End -->
                        </div>

                        <!-- Button -->
                        <div class="d-grid p-2 p-xl-0 bg-body text-center">
                            <button class="btn btn-primary mb-0">Filter Results</button>
                        </div>
                    </div>
                    <!-- Responsive offcanvas body END -->
                </div>
                <!-- Right sidebar END -->

            </div><!-- Row END -->
        </div>
    </section>
    <!-- =======================
    Page content END -->
</main>

<jsp:include page="/WEB-INF/learnx/bottom.jsp"></jsp:include>