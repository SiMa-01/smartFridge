import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.3"
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
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb:2.6.2")
	implementation("org.springframework.boot:spring-boot-starter-web:2.6.2")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
	implementation("io.springfox:springfox-boot-starter:3.0.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.2")
	testImplementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.2")
	testImplementation("org.mockito:mockito-core:3.12.4")
	testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
	testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
	testImplementation("com.h2database:h2:2.2.222")
	testImplementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

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
