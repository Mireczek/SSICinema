<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="footer text-white">
    <hr  />
    <div class="container">
        <div class="row">
            <div class="p-4 col-md-3">
                <h2 class="mb-4 text-white">MagicCinema</h2>
                <p class="text-white">Some usefull static interesting description of company</p>
            </div>
            <div class="p-4 col-md-3">
                <h2 class="mb-4 text-white">Mapsite</h2>
                <ul class="list-unstyled">
                    <a href="#" class="text-white">CINEMA</a>
                    <br>
                    <a href="#" class="text-white">REPERTUAR</a>
                    <br>
                    <a href="#" class="text-white">PROMO</a>
                </ul>
            </div>
            <div class="p-4 col-md-3">
                <h2 class="mb-4">Contact</h2>
                <p>
                    <a href="tel:+246 - 542 550 5462" class="text-white"><i
                            class="fa d-inline mr-3 fa-phone text-primary"></i>+246 - 542 550 5462</a>
                </p>
                <p>
                    <a href="mailto:info@magicinema.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@magiccinema.com</a>
                </p>
                <p>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>somewhere over the rainbow</a>
                </p>
            </div>
            <div class="p-4 col-md-3">
                <h2 class="mb-4 text-light">Subscribe</h2>
                <form>
                    <fieldset class="form-group text-white"><label for="exampleInputEmail1">Get our newsletter</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                    </fieldset>
                    <button type="submit" class="btn navbar-btn ml-2 text-white btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
