# Pojišťovna - Aplikace pro pojišťovnu

Webová aplikace v Spring Boot pro správu klientů pojišťovny.

## Funkce

*   **Autentizace uživatelů:** Uživatelé se mohou registrovat a přihlašovat do aplikace.
*   **Autorizace na základě rolí:** Aplikace podporuje běžné uživatele a administrátory s různými úrovněmi přístupu.
*   **Správa pojištěnců (CRUD):** Administrátoři mohou vytvářet, číst, upravovat a mazat záznamy pojištěných osob (Pojištěnci).

## Použité technologie

*   **Backend:**
    *   Java 18
    *   Spring Boot 3
    *   Spring Security (pro autentizaci a autorizaci)
    *   Spring Data JPA (pro interakci s databází)
    *   MapStruct (pro mapování objektů)
*   **Frontend:**
    *   Thymeleaf
*   **Databáze:**
    *   MariaDB nebo PostgreSQL (vyžaduje konfiguraci)
*   **Nástroj pro sestavení:**
    *   Maven

## Nastavení a instalace

### Předpoklady

*   JDK 18 nebo novější
*   Apache Maven
*   Běžící instance MariaDB nebo PostgreSQL

### 1. Konfigurace databáze

Tento projekt není dodáván s předkonfigurovaným připojením k databázi. Budete muset vytvořit soubor `application.properties` v adresáři `src/main/resources`.

Přidejte do souboru následující vlastnosti a upravte hodnoty pro nastavení vaší lokální databáze.

**Příklad pro MariaDB:**
```properties
# Nastavení připojení k databázi
spring.datasource.url=jdbc:mariadb://localhost:3306/pojistovna_db
spring.datasource.username=root
spring.datasource.password=vaše_heslo

# Specifikace ovladače
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

# Nastavení Hibernate
spring.jpa.hibernate.ddl-auto=update
```

**Příklad pro PostgreSQL:**
```properties
# Nastavení připojení k databázi
spring.datasource.url=jdbc:postgresql://localhost:5432/pojistovna_db
spring.datasource.username=postgres
spring.datasource.password=vaše_heslo

# Specifikace ovladače
spring.datasource.driver-class-name=org.postgresql.Driver

# Nastavení Hibernate
spring.jpa.hibernate.ddl-auto=update
```

### 2. Sestavení a spuštění

Jakmile je databáze nakonfigurována, můžete aplikaci spustit pomocí Mavenu:

```bash
mvn spring-boot:run
```

Aplikace se spustí a bude dostupná na [http://localhost:8080](http://localhost:8080).

## Použití

*   **Registrace a přihlášení:** Přejděte do aplikace a zaregistrujte si nový uživatelský účet nebo se přihlaste pomocí stávajících údajů.
*   **Přístup pro administrátory:** Chcete-li získat administrátorská oprávnění, musíte ručně aktualizovat záznam uživatele v databázi. V tabulce `user_entity` nastavte sloupec `role` pro vašeho uživatele na `ROLE_ADMIN`.
