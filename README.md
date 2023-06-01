# Back-end-CryptoCurrencyAPP

This project requires setting up a Docker environment to run a MySQL database on port 3306. Follow the instructions below to get started.
Also if you want the project to work with an front-end also you will need to run this other project: https://github.com/ArturFilipini/Front-end-CryptoCurrencyAPP .
## Prerequisites

- Docker

## Setup

1. **Install Docker:**
   - Visit the [Docker website](https://www.docker.com/) and download Docker for your operating system.
   - Follow the installation instructions specific to your OS.

2. **Set up the MySQL container:**
   - Open a terminal or command prompt.
   - Pull the MySQL Docker image by running the following command:
     ```
     docker pull mysql
     ```
   - Once the image is downloaded, create and start a MySQL container with the following command:
     ```
     docker run -d -p 3306:3306 --name mysql-container -e MYSQL_ROOT_PASSWORD=your_password mysql
     ```
     Replace `your_password` with your desired root password for the MySQL database.

3. **Verify the MySQL container:**
   - Run the command below to check if the container is running:
     ```
     docker ps
     ```
   - You should see a container named `mysql-container` with the status "Up".

4. **Initialize the project:**
  
   - Configure the project to connect to the MySQL database. Update the database connection details (such as host, port, username, password) in the project configuration file.

5. **Start the application:**
   - To run this application, make sure that the last project you run is "CryptoCurrency". Otherwise, you may encounter an error when attempting to register without the other projects running. Please note that the project names are not specified in the provided description, so make sure to replace "CryptoCurrency" with the actual name of the project that needs to be run last.
   
   - The application should now be running and accessible at the specified port.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgements

- [Docker](https://www.docker.com/)
- [MySQL](https://www.mysql.com/)
