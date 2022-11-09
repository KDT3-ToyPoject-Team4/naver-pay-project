<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Loading</title>
    <link rel="stylesheet" type="text/css" href="../../resources/css/Loading.css">
  </head>
<body>
  <div class = "loader">
    <h2>Loading...</h2>

    <script>
      setTimeout(function() {
        document.location = "crawling";
      }, 5000); // <-- this is the delay in milliseconds
    </script>

  </div>
</body>
</html>