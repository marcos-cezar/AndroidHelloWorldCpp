////
//// Created by Marcos Costa on 11/10/23.
////

#ifndef SAMPLEWITHBUTTON_HPP_H
#define SAMPLEWITHBUTTON_HPP_H

class Message {
private:
    char* content;
public:
    Message(char* content) {
        this->content = content;
    }
    ~Message() {
        content = NULL;
    }

    char* getContent() {
        return content;
    }
};

#endif //SAMPLEWITHBUTTON_HPP_H
