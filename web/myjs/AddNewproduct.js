
function getImage(input) {
                var c = 0;
                for (var i = 0; i < input.files.length; i++) {

                    if (input.files[i] !== null) {

                        var reader = new FileReader();

                        reader.onload = function(e) {

                            var elem = document.createElement("img");
                            elem.setAttribute("id", c);
                            elem.setAttribute("class", "img-thumbnail");
                            elem.setAttribute("src", e.target.result);
                            elem.setAttribute("width", "300");
                            elem.setAttribute("height", "200");
                            elem.setAttribute("style","margin:1%");
                            elem.setAttribute("onclick", 'deleteimage(' + c + ')');

                            document.getElementById("images").appendChild(elem);

                            c++;

                        };
                        reader.readAsDataURL(input.files[i]);
                    }
                }
            }
