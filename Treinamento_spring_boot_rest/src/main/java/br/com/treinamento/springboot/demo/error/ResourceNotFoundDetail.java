package br.com.treinamento.springboot.demo.error;

public class ResourceNotFoundDetail {
    private String title;
    private Long status;
    private String detail;
    private Long timestamp;
    private String developerMessage;

    private ResourceNotFoundDetail(){

    }

    public String getTitle() {
        return title;
    }

    public Long getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public static final class Builder {
        private String title;
        private Long status;
        private String detail;
        private Long timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(Long status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundDetail build() {
            ResourceNotFoundDetail resourceNotFoundDetail = new ResourceNotFoundDetail();
            resourceNotFoundDetail.timestamp = this.timestamp;
            resourceNotFoundDetail.detail = this.detail;
            resourceNotFoundDetail.status = this.status;
            resourceNotFoundDetail.title = this.title;
            resourceNotFoundDetail.developerMessage = this.developerMessage;
            return resourceNotFoundDetail;
        }
    }
}
