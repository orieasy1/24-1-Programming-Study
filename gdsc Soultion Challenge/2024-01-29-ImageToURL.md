<h1>프로필 이미지 URL로 바꾸는 기능 구현</h1>

일요일 저녁을 완전 삽질하면서 보냈던 것 같다.
감을 못잡았는데 경남오빠 코드를 짜면서 감이 많이 잡히고 느꼈던 것 같다.
그리고 29일에 이 코드를 짜면서 이런 식으로 코드를 구성하면 되지 않을까?라고 생각한 것 같다.

우선 프로필 이미지를 url로 바꾼 후 db에 저장하는 코드를 만드려고 경남오빠가 다이어리에서 음성파일을 url로 어떻게 바꿨는지 코드를 관찰해보았다.

```java
public Long save(MultipartFile audioFile, DiarySaveRequestDto requestDto, Long userId, Long activityId) {
        Users users = usersRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다. id=" + userId));

        RecommendedActivity recommendedActivity = activityRepository.findById(activityId).orElseThrow(
                () -> new IllegalArgumentException("해당 추천 활동이 없습니다. id=" + activityId));

        try {
            ClassPathResource resource = new ClassPathResource("strecording-upload.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(resource.getInputStream());
            Storage storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(credentials)
                    .build().getService();

            String uuid = UUID.randomUUID().toString(); // Google Cloud Storage에 저장될 파일 이름
            String extension = audioFile.getContentType(); //파일 형식 flac

            BlobInfo blobInfo = storage.create(BlobInfo.newBuilder(bucketName, uuid).setContentType(extension).build(), audioFile.getBytes());
            String audioUrl = "https://storage.googleapis.com/" + bucketName + "/" + uuid;
            System.out.println(audioUrl);

            Long diaryId = diaryRepository.save(requestDto.toEntity(users, audioUrl, recommendedActivity)).getId();
            return diaryId;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0L;
    }
```

우선 오빠는 save 메소드를 사용했다.
save 메소드는 스프링 프레임워크에서 제공하는 JPA 메소드이다.
JPA를 사용할 때 save 메소드는 새로운 엔티티를 데이터베이스에 저장하거나 이미 존재하는 엔티티를 업데이트하는데 사용된다.
<br><br>
코드가 흘러가는 순서를 살펴보자면

1. 사용자의 ID를 이용해 해당 사용자를 찾고 없으면 예외 처리를 한다.
2. 활동의 ID를 이요해 해당 활동을 찾고 없으면 예외 처리를 한다.
3. GoogleCredentials, Storage 객체를 생성: ggole cloud storage에 파일을 업로드하기 위해 필요한 설정을 불러온다.
4. 업로할 파일의 이름을 랜덤한 UUID로 생성한다.
5. 업로드할 파일의 확장자를 가져온다.
