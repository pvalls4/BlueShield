<%@ include file="./header.jsp" %>
<div class="d-flex justify-content-center">
    <div class="d-flex flex-column justify-content-center w-30"> 
        <div class="d-flex justify-content-center">
            <img src="./images/logoBS.png" class="logo">
        </div>
         <form action="/dashboard">
            <div class="mb-3 mt-3">
              <label for="email" class="form-label text-darkblue">Email:</label>
              <input type="email" class="form-control input-color" id="email" placeholder="Enter email" name="email">
            </div>
            <div class="mb-3">
              <label for="pwd" class="form-label text-darkblue">Password:</label>
              <input type="password" class="form-control input-color" id="pwd" placeholder="Enter password" name="pswd">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
          </form>
    </div>
</div>
<%@ include file="./footer.jsp" %>
