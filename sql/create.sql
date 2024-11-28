-- Table for Users
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(100) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table for Projects
CREATE TABLE projects (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          start_date DATE,
                          end_date DATE
);

-- Table for Tasks
CREATE TABLE tasks (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       completed BOOLEAN DEFAULT FALSE,
                       project_id BIGINT,
                       user_id BIGINT,
                       FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE,
                       FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);

-- Table for Comments
CREATE TABLE comments (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          content TEXT NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          task_id BIGINT,
                          FOREIGN KEY (task_id) REFERENCES tasks(id) ON DELETE CASCADE
);
