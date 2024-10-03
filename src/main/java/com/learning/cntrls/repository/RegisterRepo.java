package com.learning.cntrls.repository;

import com.learning.cntrls.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Integer> {
    public Optional<Register> findByEmail(String email);
    public Optional<Register> findByMobileNo(String mobileNo);
}


/**
 *
 * In Spring Boot, you can use **JPQL (Java Persistence Query Language)** and **native queries** to interact with the database using JPA (Java Persistence API). Here's an explanation of both:
 *
 * ### 1. **JPQL (Java Persistence Query Language)**
 * - **What it is**: JPQL is an object-oriented query language, similar to SQL but designed for JPA. It allows you to write database queries based on the **entity model** instead of the underlying database tables.
 * - **Features**:
 *   - Operates on the entity objects rather than database tables.
 *   - Follows the syntax of SQL but uses **entity field names** instead of table column names.
 *   - Queries can be used for complex operations such as joins, aggregations, and subqueries.
 * - **Example**:
 *   ```java
 *   @Query("SELECT u FROM User u WHERE u.email = :email")
 *   User findByEmail(@Param("email") String email);
 *   ```
 *   In this example:
 *   - `User` is the entity class.
 *   - `email` is a field in the `User` entity.
 *   - The query returns a `User` object where the `email` matches the provided parameter.
 *
 * ### 2. **Native Queries**
 * - **What it is**: Native queries allow you to write SQL queries directly, bypassing JPA and entity models. These queries are executed directly on the database, making them more powerful in specific situations, such as when using **database-specific functions** or **advanced SQL features**.
 * - **Features**:
 *   - Can be more efficient for certain database-specific optimizations.
 *   - Directly interacts with the database schema, not JPA entities.
 *   - Useful for complex queries that can't be easily expressed with JPQL.
 * - **Example**:
 *   ```java
 *   @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
 *   User findByEmailNative(@Param("email") String email);
 *   ```
 *   In this example:
 *   - `users` is the database table.
 *   - The query is a direct SQL statement.
 *
 * ### **Key Differences**:
 * | Feature            | JPQL                                            | Native Query                                   |
 * |--------------------|-------------------------------------------------|------------------------------------------------|
 * | **Query Type**      | Object-oriented (on entities and fields)        | Relational (direct SQL on tables and columns)  |
 * | **Database Agnostic** | Yes (works with any database supported by JPA) | No (may need to change depending on the database) |
 * | **Syntax**          | JPQL syntax, similar to HQL                     | Standard SQL                                   |
 * | **Usage**           | Ideal for standard CRUD and entity operations   | Useful for complex queries or database-specific optimizations |
 * | **Portability**     | More portable across different databases        | Less portable (database-specific features might be used) |
 *
 * ### When to Use:
 * - **JPQL**: Use when you want to work with entities and you need database independence.
 * - **Native Queries**: Use when you need to leverage specific database features or perform queries that JPQL cannot express efficiently.
 *
 * Let me know if you need more examples or clarification!
 *
 */