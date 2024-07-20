import java.util.regex.Pattern.compile

plugins {
	java
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "com.studies"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.wiremock:wiremock:3.8.0")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("io.github.openfeign:feign-core:13.3")
	implementation("io.github.openfeign:feign-gson:13.1")
	implementation("com.google.code.gson:gson:2.11.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
