import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.mongodb:mongodb-driver-kotlin-coroutine:4.11.0")
	implementation("org.mongodb:bson-kotlinx:4.11.0")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.springfox:springfox-boot-starter:3.0.0")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

	testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
	testImplementation("org.mockito:mockito-core")
	testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
	testImplementation ("org.junit.jupiter:junit-jupiter-api:5.7.0")
	testImplementation ("org.junit.jupiter:junit-jupiter-engine:5.7.0")
	testImplementation ("org.mockito:mockito-core:3.6.0")
	testImplementation ("org.springframework.boot:spring-boot-starter-data-mongodb")
	testImplementation("com.h2database:h2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.jar {
	manifest {
		attributes["Main-Class"] = "com.example.shoppingList.ShoppingListApplication.kt" // Hier muss die vollständige Pfadangabe zur Hauptklasse Ihrer Anwendung stehen
	}
}