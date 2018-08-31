package br.com.alexandre.app.CustomMessage;

import java.util.Calendar;
import java.util.Date;

public class ResourceNotFoundDetais {
    private String title;
    private int status;
    private String detail;
    private Calendar timestamp;
    private String developerMessage;

    private ResourceNotFoundDetais() {
    }

    
    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private Calendar timestamp;
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

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(Calendar timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundDetais build() {
            ResourceNotFoundDetais resourceNotFoundDetais = new ResourceNotFoundDetais();
            resourceNotFoundDetais.detail = this.detail;
            resourceNotFoundDetais.status = this.status;
            resourceNotFoundDetais.title = this.title;
            resourceNotFoundDetais.timestamp = this.timestamp;
            resourceNotFoundDetais.developerMessage = this.developerMessage;
            return resourceNotFoundDetais;
        }
    }
}
