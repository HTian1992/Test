package com.dao;

import org.mybatis.generator.api.ShellRunner;

public class MybatisGenerator {

	public static void main(String[] args) {

		String[] mkdir = new String[3];
		mkdir[0] = "-configfile";
		mkdir[1] = "src/test/resources/generatorConfig.xml";
		mkdir[2] = "-overwrite";

		ShellRunner.main(mkdir);


	}

}
