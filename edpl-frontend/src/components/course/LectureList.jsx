import { List } from 'antd';

const LectureList = ({ lectures }) => {
  return (
    <List
      bordered
      dataSource={lectures}
      renderItem={(lecture) => <List.Item>{lecture.name}</List.Item>}
    />
  );
};

export default LectureList;