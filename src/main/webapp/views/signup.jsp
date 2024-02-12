 

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="static\css\style.css" />

    <script
      src="https://kit.fontawesome.com/ae336e36f1.js"
      crossorigin="anonymous"
    ></script>
  </head>

  <body>
   
    <main
      class="primary-background banner-background d-flex align-items-center"
      style="height: 97vh"
    >
      <div class="container">
        <div class="row">
          <div class="col-md-4 offset-md-4">
            <div class="card c1  text-dark  shadow border-3">
              <div class="card-header text-center">
                <div>
                  <span>REGISTER</span>
                </div>
                <span class="fa fa-user-circle fa-3x"></span>

                <div class="card-body">
                  <form id="reg_form" action="/user/register" method="post">
                    <div class="form-group">
                      <input
                        name="userName"
                        type="text"
                        class="form-control mb-2"
                        id="userName"
                        placeholder="Enter name"
                      />
                      
                    </div>
                    <div class="form-group">
                      <input
                        type="password"
                        name="userPassword"
                        class="form-control mb-2"
                        id="userPassword"
                        placeholder="Enter Password"
                      />
                    </div>
                    <div class="form-group">
                      <input
                        type="text"
                        name="userMobile"
                        class="form-control mb-2"
                        id="userMobile"
                        placeholder="Enter phone number"
                      />
                    </div>
                    

                    
                     
                     

                    <!-- <div id="loader" class="text-center container">
                      <span class="fa fa-refresh fa-spin fa-3x mb-2"></span>
                    </div> -->
                    <div class="text-center">
                      <button
                        id="done"
                        type="submit"
                        class="btn btn-primary btn-hov mt-2"
                        style="background-color: black; border-color: black"
                      >
                        Submit
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>

    <!-- <script>
      $(document).ready(function () {
        console.log("hmmlll");
        $("#loader").hide();
        $("#done").show();

        $("#reg_form").on("submit", function (event) {
          event.preventDefault();

          // Hide the submit button and show the loader
          $("#done").hide();
          $("#loader").show();

          let formData = new FormData(this);

          $.ajax({
            url: "registerservlet",
            type: "POST",
            data: formData,
            success: function (data, textStatus, jqXHR) {
              console.log(data);

              // Hide the loader and show the submit button
              $("#loader").hide();
              $("#done").show();

              if (data.trim() === "done") {
                swal(
                  "Registered successfully. Redirecting to login page "
                ).then((value) => {
                  window.location = "login.jsp";
                });
              } else {
                swal(data);
              }
            },
            error: function (jqXHR, textStatus, errorThrown) {
              console.log(error);

              // Hide the loader and show the submit button
              $("#loader").hide();
              $("#done").show();

              swal("Something went wrong. Try again.");
            },
            processData: false,
            contentType: false,
          });
        });
      });
    </script> -->

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"
    ></script>

    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"
      integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    ></script>
  </body>
</html>
