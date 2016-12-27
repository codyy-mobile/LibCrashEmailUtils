# LibCrashEmailUtils
通过邮件发送CrashLog
## How to
**Step 1. Add the JitPack repository to your build file**

Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
**Step 2. Add the dependency**
```
dependencies {
	        compile 'com.github.CodyyAndroid:LibCrashEmailUtils:v1.0.0'
	}
```
**Step 3. Use**
```
MailUtils.sendMail(new CrashMail("SMTPHost", "title", "log", "****@****.com", "发件人名称", "password", "****@****.com", "收件人名称"));
```
## [LICENSE](https://github.com/CodyyAndroid/LibCrashEmailUtils/blob/master/LICENSE)
```
Copyright 2016 codyy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
